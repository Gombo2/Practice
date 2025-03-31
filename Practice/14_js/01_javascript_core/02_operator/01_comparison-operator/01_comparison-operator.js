
/* 1. 숫자 1, 문자 '1' , true 비교 */
console.log(`1 == 1: ${1 == 1}`); // true
console.log(`1 == true: ${1 == true}`); // true
console.log(`1 == '1': ${1 == '1'}`); // true 동등비교
console.log(`1 === '1': ${1 === '1'}`); // false 동일비교(타입 포함)


/* 2. NaN는 자신과 일치하지 않은 유일한 값이다. */
console.log(`NaN == NaN: ${NaN == NaN}`); // false
console.log(`NaN === NaN: ${NaN === NaN}`); // false

/*3. 일치하지 않는 값 비교 */
console.log(`1 != '1': ${1 != '1'}`); // false
console.log(`1 !== '1': ${1 !== '1'}`); // true