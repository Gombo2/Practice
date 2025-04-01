// 기본 선언 방식 (함수 선언문 형태)
function hello(name) {
    return `${name}님 안녕하세요!`;
};

console.log(hello('홍길동'));

//함수를 하나의 값으로 생각. (함수 표현식 형태)
/*
  자바 스크립트의 함수는 객체 타입의 값으로 값의 성질을 가지는 객체로써 일급 객체라고 한다
  따라서 함수 리터럴로 생성한 함수 객체를 변수에 할당할 수 있다.
*/

var hello2 = function(name) {
    return `${name}님 반갑습니다!`;
};

console.log(hello('강감찬'));