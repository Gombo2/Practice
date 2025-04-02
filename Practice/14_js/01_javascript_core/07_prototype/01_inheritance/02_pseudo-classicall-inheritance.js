/* 생성자 함수 기반 상속 또는 의사 클래스 상속 */

/* 부모 생성자 함수 */
function Parent(name) {
    this.name = name;
}

// 아빠 -> property(속성값)을 주고 엄마 -> property(기능)을 주는 방식이 요즘의 관례이다.
/* 부모 프로토타입 */
console.log(Parent.prototype);
Parent.prototype.sayHello = function() {
    console.log(`Hello, I'm ${this.name}`);
};

/* 자식 생성자 함수 */
function Child(name, age) {
    // 자식 객체란걸 넘겨주면 자식 객체라고 this의 의미가 변한다.
    Parent.call(this, name);    //자바의 super() 개념
    this.age = age;
}

//프로토 타입 갈아끼우기 안되면 자식 클래스 원하는대로 못만듬!
Child.prototype = Object.create(Parent.prototype);
Child.prototype.constructor = Child;

Child.prototype.sayAge = function() {
    console.log(`I'm ${this.age} years old`);
}

//이제 자식 객체 생성 가능.
const child = new Child('홍길동', 20);
child.sayHello();
child.sayAge();

/* ----------------------------------------------------- */
class Parent {
    constructor(name) {
        this.name = name;
    }

    // 단축 문법
    sayHello() {
        console.log(`Hello, I'm ${this.name}`);
    }
}

class Child extends Parent {
    constructor(name, age) {
        super(name);
        this.age = age;
    }

    sayAge() {
        console.log(`I'm ${this.age} years old`);
    }
}

const child2 = new Child('유관순', 15);
child2.sayHello();
child2.sayAge();
