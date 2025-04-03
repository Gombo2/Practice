let exampleProduct = {
    items: ['Coffee', 'Donut'],
    producer: '신사임당'
};

/* 객체를 단순하게 받아내는 매개변수 사용 시 */
function displayProduct(obj) {

    /* obj.를 항상 명시해야 함*/
    console.log(obj.producer);
    console.log(obj.items);

    /* 2. 인수로 던져진 객채에 필요한 프로퍼티가 없을 경우(undefined가 나옴) */
    console.log(obj.brand);
}

displayProduct(exampleProduct);

/* 매개변수에서 객체 구조 분해 할당 적용 시시*/
function displayProduct2({producer = '아무개', items = [], brand = '한화'}) {
    console.log(producer);
    console.log(items);
    console.log(brand);
}

displayProduct2(exampleProduct);