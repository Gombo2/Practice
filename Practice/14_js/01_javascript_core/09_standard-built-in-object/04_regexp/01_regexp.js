
/* 정규 표현식 */
let regex = /j/i;  //패턴  ( / / 안에 있는걸 패턴으로 가지고, 그 문자열이 소문자 j를 만족하느냐로 쓸 수 있다.)
regex = new RegExp('j', 'i');
regex = new RegExp(/j/, 'i');
regex = new RegExp(/j/i);
// 다 동일한 기능이다.
/* 옆에 i는 flag option 으로서, 대소문자 구분하지 말라는 이야기다. */

let target = "JavaScript";

/* 유효성 검사(validation check)를 할 수 있다. */
// regex에서 제공해주는 기본 테스트 유효성 검사 boolean으로 반환해준다.
console.log(regex.test(target));    // target 문자열이 패턴에 맞으면 true(유효하다)