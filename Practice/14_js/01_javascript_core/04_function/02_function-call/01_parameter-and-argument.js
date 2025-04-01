function hello(name) {
    console.log('넘어온 값:', name);

    //모든 함수는 argument를 사용할 수 있다.
    /* 모든 인수(전달인자)는 함수 안에서 arguments 객체의 프로퍼티로 보관된다. */
    console.log('arguments', arguments);
    console.log('두번째 인수: ', arguments[1]);
    return `${name}님 안녕하세요!`;
}

// var result = hello('홍길동');
// console.log('result:', result); 

// var result = hello();
// console.log('result:', result); 

var result = hello('홍길동', '유관순');
console.log('result:', result); 