
/* null 병합 연산자 */
/*
    좌항의 피연산자가 null이거나, undefined일 경우 우항의 결과가 남고(함수면 실행),
    그렇지 않으면 좌항이 남는다(함수면 실행)
*/


var test = null ?? '기본 값';
console.log('test',test); // 기본 값 하나씩 변수값 추가할때 용이 dotted.log 플러그인 깔아야햄 test.log 하면됨
                          // console.log 는 매개변수를 두개 이상 쓰면 중간에
                          // 띄어쓰기를 포함해서 문자열 이어붙이기가 가능

var value1 = '' || '기본 값';
var value2 = '' ?? '기본 값';
console.log('value1',value1); // 기본 값
console.log('value2',value2); // 기본 값
