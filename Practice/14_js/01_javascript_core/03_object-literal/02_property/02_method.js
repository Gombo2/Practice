
var dog = {
    name: '뽀삐',
    eat: function(food) {
        /* this.은 프로퍼티, 안 붙이면 매개변수(혹은 전역변수) */
        console.log(`${this.name}(은)는 ${this.food}를 맛있게 먹어요.`);
    }
}

/* 매개변수 있는 메소드를 호출할 수 있고 매개변수의 갯수를 지키지 않아도 동작한다. */
dog.eat();
dog.eat('고구마');
dog.eat('고구마', '딸기');

