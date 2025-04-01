/* 함수이자 생성자 역할을 할 수 있다. */
function Student(name, age) {
    this.name = name;                 // 단순 함수일 때 내부의 this.은 전역 객체를 말한다.
    this.age = age;
    this.getInfo = function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }

    return this.getInfo; // 반환을 해도 되고 안해도 된다. (애초에 반환형이 없기 때문에)
}

/* new 연산자를 안 붙이고 일반 함수로 썼을 때 내부의 this는 전역 객체이며 함수명만 대문자로 시작하는 상태. */
const student = Student('강감찬', 35); // 생성자로 만든게 아니라서 상위 객체가 있나 찾게됨 -> globalthis로 매칭됨
// 위의 student -> 일반 함수로서 활용 시
console.log(student);

// console.log(this)
// // {} -> 가짜 전역 개체

// console.log(globalThis);    // 글로벌 객체

function Dog(name, age) {
    console.log('new.target', new.target);

    if(!new.target) {
        return new Dog(name,age);
    }

    this.name = name;               // 여기서의 this는 생성자 함수로 만들어질 객체
    this.age = age;
}

const dog = new Dog("뽀삐", 3);
console.log(dog);

function Dog(name, age) {
    console.log('new.target', new.target);

    this.name = name;               // 여기서의 this는 생성자 함수로 만들어질 객체
    this.age = age;
}

const dog2 = Dog("뽀삐", 3);
console.log(dog2);

/* 제공되는 빌트인 함수들 : Object, String, Number, Boolean, Date, Regex, .... */