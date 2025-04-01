var sym = Symbol('심볼');

var student = {
    name: '유관순',
    age: 16,
    test: undefined
};

student[sym] = '추가';
console.log(student); // Symbol이 프로퍼티로 추가되지만 for-in문에선 숨겨진다.

console.log('name' in student);
console.log('age' in student);
console.log('test' in student);

/* for-in문(프로퍼티 순회 용도) */
for(var key in student) {
    console.log(`key: ${key}`);
    console.log(`student[${key}]: ${student[key]}`);
    console.log(`<td>${student[key]}</td>`);
}