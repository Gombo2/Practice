
/*
  ES11(2020)에 도입된 연산자로 연산자의 좌항이 null 또는 undefined일 경우
  에러 대신 undefiend를 반환하고 그렇지 않으면 우향의 프로퍼티 참조를 이어간다.
*/

var obj = null;

var val = obj?.value;
console.log(val); // NPE 방지 코드