var dog = {
    name: '뽀삐',
    eat: function(food) {
        console.log(`${this.name}(은)는 ${food}를 맛있게 먹어요.`);
    }
};

/* 1. 마침표 표기법(dot notation) */
console.log(dog.name); // 뽀삐
dog.eat('감자');


/* 2. 대괄호 표기법(square braket notation) */
console.log(dog['name']); // 뽀삐
dog['eat']('고구마');

/* 3. 대괄호 표기법을 특별히 고려해야 하는 경우 */
var obj = {
    under_key: 'under_key', // 프로퍼티키를 문자열이 아닌 형태로 할 수 있는건 _ , $ 만 가능.
    'dash-key': 'dash-key',   // 대쉬(-)는 사용할 수 없다. 사용하려면 ' ' 사용해야
    0: 1
};

/* 마침표 표기법은 접근에 한계가 있다. */
// console.log(obj.under_key);
// console.log(objdash-key);
// console.log(obj.0);

/* 대괄호 표기법은 다양한 형태의 프로퍼티들을 모두 접근할 수 있다. */
console.log(obj['under_key']); // under_key
console.log(obj['dash-key']); // dash-key
console.log(obj['0']); // 1
console.log(obj[0]); // 숫자 프로퍼티 키일 경우에는 숫자로 바로 접근 가능.