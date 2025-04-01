/*
  자바스크립트는 프로토타입 기반의 객체 지향(기반) 프로그래밍 언어로 원시 값을 제외한 나머지 값
  (함수, 배열, 정규표현식 등)은 모두 객체이다.(feat.프로토 타입을 가지면 객체)
*/

// 이건 단순 변수 두개다.
var name = '홍씨';
var age = 10;

// java의 클래스와 같은 모습이지만, 다르다. heap 메모리에 올라가며 
/* {} 중괄호 사용시 객체가 된다. ,을 기준으로 하나의 프로퍼티 */
var student = {
    /* 속성 프로퍼티 */
    name: '유관순',
    age: 16,

    /* 기능 프로퍼티 */
    /* 속성의 값이 함수인 프로퍼티는 '메소드'이다. */
    /* 메소드 안에서는 this.을 반드시 쓰자 (안쓰면 전역 변수가 나올 수 있음) */
    getInfo: function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;  // this는 메소드가 포함된 객체
    }
};

console.log('student',student); // student { name: '유관순', age: 16, getInfo: [Function: getInfo] }
console.log('이름:', student.name); // 이름: 유관순
console.log('나이:', student.age);
// console.log('정보:', student.getInfo); // 메소드 찍어보기 (이름이 없었는데, 생김)
console.log('정보:', student.getInfo()); // 메소드 호출 (메소드는 접근하면 소괄호(())를 통해 실행 가능)

console.log(this);