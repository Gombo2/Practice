/* 콜백함수 1 */
function increase(value) {
    return value + 1;
}

/* 콜백함수 2*/
function decrease(value) {
    return value - 1;
}

// 고차함수 : 다른 함수를 사용하는 함수.
function apply(func, value) {
    return func(value);
}

console.log(apply(increase, 5));    // increase 함수가 콜백
console.log(apply(decrease, 5));    // decrease 함수가 콜백

//고차함수 예제
console.log([3, 2, 1, 5, 4].sort(function(left, right) {return right - left;}));
//Arrow function 으로 변환
console.log([3, 2, 1, 5, 4].sort((left, right) => left - right));

/* 비동기 처리 (이벤트, 타이머, ajax, fetch, ...) 할때 콜백 쓰임(고차함수) */