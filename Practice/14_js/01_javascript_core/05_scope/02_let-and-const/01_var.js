/* 함수 레벨 스코프 */
/*
  C, 자바 등 대부분의 프로그래밍 언어는 모든 코드 블록(if, for, while, try/catch 등)이
  지역 스코프를 만드는 블록레벨 스코프(block level scope)를 가진다.
  하지만 var 키워드로 선언된 변수는 함수의 코드블록(함수 몸체)만을 지역 스코프로 인정하는
  함수 레벨 스코프(function level scope)를 가진다.
*/
// var i = 0;
let i = 0;
// for(var i = 0; i < 10; i++) {
for(let i = 0; i < 10; i++) {

}

/* var 는 block level scope를 인정하지 않는다. 위에 for문의  { } 이걸 */
console.log(i); //자바였음 0나와야하는데 10나옴. //for문 안의 var i가 for문 범위를 인정하지 않음을 확인

/* var 키워드의 특징 */
/* 1. 같은 범위(같은 함수 레벨 스코프)에서 변수 중복 선언 가능 */
var msg = '안녕하세요';
console.log('msg',msg);

var msg = '안녕히 가세요';
console.log('msg',msg);

var msg;
console.log('msg',msg);     //초기화 되지 않고 중복 선언된 경우는 무시됨(불규칙);

/* 2. 함수레벨 스코프만 인정(앞서 살펴봄) */

/* 3. 변수 호이스팅 */
console.log(test);         // undefined

test = '반갑습니다.';       // 대입이 안된 상태로 호이스팅 함
var test;