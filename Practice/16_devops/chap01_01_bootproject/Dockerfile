## build된 jar 파일이 있는 경우
#FROM eclipse-temurin:17-jre-alpine
#WORKDIR /app
#COPY build/libs/*.jar ./
#RUN mv $(ls *.jar | grep -v plain) app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

## 2. build 후 jar 파일로 실행되게 수정(멀티 스테이징)
## 2-1. gradle 이미지로 build(jar 생성)
FROM gradle:8.5-jdk17 AS build

WORKDIR /app

COPY . .

## daemon 스레드를 쓰지 않음으로써 쓸데없이 리소스가 소모되는것을 방지하는 코드로 작성
#RUN gradle clean build --no-daemon
# 테스트 코드 확인 안할 경우
RUN gradle clean build --no-daemon -x test

## 2-2. 앞선 build라는 이름의 스테이지 결과로 실행 스테이지를 시작
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar ./
RUN mv $(ls *.jar | grep -v plain) app.jar

## 컨테이너 내부에서는 도커에서 만들어진 이미지로 7777포트로 app.jar가 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
