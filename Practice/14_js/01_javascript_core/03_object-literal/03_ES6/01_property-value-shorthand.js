/* 프로퍼티 값 단축 (feat. 변수로 리터럴 객체 쉽게 만들기) */

var id = 'p-0001';
var price = 30000;

var product = {
    id: id,
    price: price
};
console.log('product', product); // { id: 'p-0001', price: 30000 }
// ES6에서는 프로퍼티 값 단축을 지원한다.

/* 변수명이 곧 프로퍼티 키, 변수 값이 프로퍼티 값이 된다. */
var product2 = {id,price}; // id, price는 변수명과 프로퍼티명이 동일하므로 단축 가능
console.log('product2', product2); // { id: 'p-0001', price: 30000 }