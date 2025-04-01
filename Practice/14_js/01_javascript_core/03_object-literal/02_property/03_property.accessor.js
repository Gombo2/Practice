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
