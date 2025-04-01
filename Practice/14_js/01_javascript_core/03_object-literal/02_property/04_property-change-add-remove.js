var dog = {
    name: '뽀삐'
};

dog.name = '두부';  // 속성값 변경
console.log(dog); 

dog.age = 3;        // 속성 추가
console.log(dog);

delete dog.age;     // 속성 삭제
console.log(dog);