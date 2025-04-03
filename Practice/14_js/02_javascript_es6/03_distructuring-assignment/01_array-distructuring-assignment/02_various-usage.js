
/* 다양한 사용법 */
let user = {};
[user.firstName, user.lastName] = 'Gwansoon Yu'.split(' ');

console.log(user);

// rest 문법 (나머지 것들)
let [first, second, ...rest] = ['양자리', '황소자리', '쌍둥이자리', '게자리', '사자자리', '처녀자리'];

console.log('first',first);
console.log('second',second);
console.log('rest',rest);       //나머지 요소들은 배열로 받아낼 수 있다.

/* 배열 구조 분해 할당을 활용한 변수 교환 */
let student = '유관순';
let teacher = '홍길동';

[student, teacher] = [teacher, student];x;
console.log(`학생: ${student}, 교사: ${teacher}`);

/* 기본 값을 설정하고 애해할 수도 있다. */
// let[firstName2, lastName2] = ['길동'];
let[firstName2 = '아무개', lastName2 = '김'] = ['길동'];
console.log('firstName2',firstName2);
console.log('lastName2',lastName2);


