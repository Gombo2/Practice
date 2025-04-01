console.log(hello('이몽룡'));


function hello(name) {
    return `${name}님 반갑소!`;
};

/* 표현식으로 된것도 될까? */
/* 함수 표현식은 함수 호이스팅이 발생하지 않는다. */

console.log(hi('피카츄'));

var hi = function(name) {
    return `${name} 안녕!`;
};

/*
  함수 선언문은 런타임 이전 자바스크립트 엔진에 의해 먼저 해석된다.(컴파일적인 요소)
  따라서 함수 선언문 이전에 함수를 참조할 수 있으며 호출할 수도 있다.
*/