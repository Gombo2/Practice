
/* 객체 리터럴 기반 상속 또는 프로토타입 직접 연결 상속 */
const user = {
    activate: true,
    login: function() {
        console.log('로그인 되었습니다.');
    }
};

console.log(user);
console.log(typeof user);

// console.log(user.constructor);  // 개인 확인용
console.log(user.constructor == Object);
// console.log(user.__proto__);   // 개인 확인용
console.log(user.__proto__ == Object.prototype);
console.log(user.constructor == Object.prototype.constructor);

// __proto__ 보다 getPRototypeOf를 더 권장한다. (웹 브라우저를 탈 수 있음)
// __proto__ 는 권장되지 않고 Object의 getPrototypeOf()사용을 권장하고 있다.(일부 JS 엔진이나 웹 브라우저 이슈) 
console.log(Object.getPrototypeOf(user) == Object.prototype);

/* 상속 */
const user2 = {
    activate: '활성화상태',
    login: function() {
        console.log('로그인 실패되었습니다.');
    }
};

console.log(user2.__proto__);

const student = {
    passion: true
};

// 자신(객체)에게 없는 메소드같은걸 사용하려고 할시 -> 자신의 프로토타입을 뒤져본다.(프로토타입을 다른 객체로 하면 상속이라고 한다.)
// student.__proto__ = user2; //밑과 동일
Obejct.setPrototypeOf(student, user2);
console.log(student.activate);

const greedyStudent = {
    class: 1
};

/* 프로토타입 체인을 통한 접근*/
/* greedyStudent -> student -> user2 -> Object.prototpye -> null */
greedyStudent.__proto__ = student;
console.log(greedyStudent.passion);
greedyStudent.login();

