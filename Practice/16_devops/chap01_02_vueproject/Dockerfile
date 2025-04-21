FROM node:lts-alpine

## curl(client url) 설치
## curl을 통해 npx를 설치한다.
RUN apk add --no-cache curl

WORKDIR /app

COPY . .

## 이미지로 만들어 질때 node.js가 설치되어 있지 않기 때문에
## npm install을 통해 node_modules를 설치해준다.
RUN npm install

## 도커의 문법에 맞게 작성한 DSL 파일
## npm run dev --host 0.0.0.0
## --host 0.0.0.0은 네트워크 인터페이스에서 접속을 허용하도록 설정(Docker 컨테이너 외부에서 접속 가능)
## 중간의 이중 대쉬(--)는 npm run 명령어와 그 뒤에 오는 인자를 구분하는 역할을 한다.
## 각 요소는 ""(더블 쿼테이션)로 감싸준다.
CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]