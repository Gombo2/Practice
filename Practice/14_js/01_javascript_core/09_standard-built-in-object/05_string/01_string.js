
const str = new String('홍길동');
str[0] = '김';      // String은 배열 같지만 배열이 아니다.(수정 불가)
//writeable -> false라 안바뀜.

// 하지만 읽기는 가능하다.
console.log(str[0]);
console.log(str[1]);
console.log(str[2]);
console.log(str.length);

console.log(str);
console.log(Object.getOwnPropertyDescriptors(str));