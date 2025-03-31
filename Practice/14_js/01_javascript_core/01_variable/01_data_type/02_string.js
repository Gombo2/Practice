var str = '안녕하세요';
console.log(typeof str);

var str2 = `안녕하세요. 
반갑습니다.`;

/* 백틱(`) 키를 이용하면 여러줄 문자열을 인식할 수 있다. */
// string 형은 enter를 통해 개행을 하면 안된다.
// ''이 아닌 ``로 하면 오류가 안난다.
// console.log('multiline: ' + str2);
console.log("multiline: " + str2);  // 문자열은 홀따움표(') 또는 쌍따움표("") 모두 가능하다.

/* Template Literal */
/* 표현식 삽입(${}, Template Literal)과 백틱(`)을 함께 사용하면 가독성도 좋고 간편하게 작성 가능능 */
// (표현식 : 하나의 리터럴 값이 되게 하는 식) 
var lastName = '길동';
var firstName = '홍';
console.log('제 이름은 ' + lastName + ' ' + firstName + '입니다.');
console.log(`제 이름은 ${lastName} ${firstName}입니다.`); // Template Literal을 사용하면 ${}를 통해 변수를 사용할 수 있다.
// ${}안에 ${1+2} 같이 하나의 값이 나오는 표현식이면 다 된다.
console.log(`${1+2}`);