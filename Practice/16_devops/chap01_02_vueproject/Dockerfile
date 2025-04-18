FROM node:lts-alpine

WORKDIR /app

COPY . .

## 이미지로 만들어 질때 node.js가 설치되어 있지 않기 때문에
## npm install을 통해 node_modules를 설치해준다.
RUN npm install

## 도커의 문법에 맞게 작성한 DSL 파일
CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]