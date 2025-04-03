
/* 다양한 사용법 */
let shirts = {
    productName: '베이직 셔츠'  
};

/* 객체도 default 설정이 가능하다. (undefined) 안나오게 */
let {productName:pr = '어떤 상품', color = '어떤 색상', price = 0} = shirts;

console.log('productName',pr);
console.log('color',color);
console.log('price',price);

let pants = {
    productName: '밀리터리 팬츠',
    color: '국방색',
    price: 25000
};

/* */
let {productName, ...rest} = pants;
console.log('productName',productName);
console.log('rest:', rest);
console.log('color:', rest.color);
console.log('price:', rest.price);