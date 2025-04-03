let arr = [10, 30, 20];
console.log(arr);
console.log(...arr);

console.log(`가장 큰 값: ${Math.max(10,30,20)}`);
console.log(`가장 큰 값: ${Math.max(...arr)}`);

/* 배열로 결합(concat)해서 하나의 배열로 만듦 */
let arr1 = [10, 30, 20];
let arr2 = [100, 300, 200];

console.log([...arr1, ...arr2]);                // arr1을 기준으로 arr2를 결합
console.log([10, ...arr1, -1, ...arr2]);