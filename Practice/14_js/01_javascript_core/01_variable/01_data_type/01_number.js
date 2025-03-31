/*
  data-type은 값의 종류를 말하며, 자바스크립트(ES6)는 7개의 데이터 타입
  (number, string, boolean, undefined, null, symbol, object)를 제공한다.
*/

/* 정수, 실수, 음수 모두 숫자(number) 타입이다. (내부적으로는 실수로만 인식) */
var integer = 10;
var double = 5.5;
var negative = -10;

console.log(typeof integer);

integer = '한글';
console.log(typeof integer);

console.log(typeof double);
console.log(typeof negative);

console.log(10 / 4);
console.log(10 / -0);
console.long(1 * '문자열');
console.log("문자열");