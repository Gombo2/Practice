/* 메소드 단축 */

var pika = {
    name: '피카츄',
    eat: function(food) {
        console.log('${food}를 먹는다.');
    }
};

pika.eat('백만볼트');

var pika2 = {
    name: '피카츄',
    eat(food) {     // 콜론을 없애고 마치 기명함수처럼 작성할 수 있다.
        console.log('${food}를 먹는다.');
    }
};

pika2.eat('백만볼트');

