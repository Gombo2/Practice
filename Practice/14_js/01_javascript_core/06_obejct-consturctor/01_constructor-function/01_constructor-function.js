
//얘가 객체를 만들 때 사용되는 생성자 함수가 됨 (아빠의 역할)
// +프로토 타입과 만나 객체가 된다. 

/* 생성자 함수를 활용한 객체 생성*/
/* 생성자의 용도로 쓰이는 함수는 첫 글자를 대문자로 한다. (관례상) */
function Student(name, age) {
    this.name = name;
    this.age = age;
    this.getInfo = function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
}

const student1 = new Student('장보고', 30);
const student2 = new Student('신사임당', 40);

console.log(student1);
console.log(student2);

// 기존의 literal 객체를 활용한 객체 생성 방식
 const student3 = {
    name: '장보고',
    age: 30,
    getInfo: function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
 };

 const student4 = {
    name: '신사임당',
    age: 40,
    getInfo: function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
 };

 console.log(student3);
 console.log(student4)