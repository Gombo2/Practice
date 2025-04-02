let target = "Java JavaScript";

console.log(target.match(/VA/));
console.log(target.match(/VA/i));
console.log(target.match(/VA/ig));

/* . : 임의의 문자 한 개*/
target = 'abcdefg';
console.log(target.match(/./g));    //문자 하나인 패턴을 찾아줘 글로벌하게.
console.log(target.match(/../g));    //문자 두개인 패턴을 찾아줘 글로벌하게.

target = 'a aa aaa b bb bbb bbbb ab aab abb';
/* {m,n} 최소 m번, 최대 n번 반복되는 문자열(반복 검색) */
console.log(target.match(/a/g));    // a에 대해 전체에서 다 찾아줘
console.log(target.match(/a{2,3}/g));    // a가 최소 2번 최대 3번 반복하는 것들에 대해 전체에서 다 찾아줘
console.log(target.match(/b{2}/g));  // b가 2번 나오는 b에 대해 전체에서 다 찾아줘.

console.log(target.match(/b{3,}/g)); // b에 대해 최소 3번 이상 반복되는 것들에 대해 전체에서 다 찾아줘. 

/* +: 앞선 패턴이 최소 한번 이상 반복되는 문자열 */
console.log(target.match(/b+/g));  // b가 한번이라도 나온거에 대해서 찾아줘?
console.log(target.match(/b{1,}/g)); // b에 대해 최소 1번 이상 반복되는 것들에 대해 전체에서 다 찾아줘. 
// {} 안에서 띄어쓰면 안됨.

target = 'soul seoul seeoul';
console.log(target.match(/se?oul/g));   // e가 없거나 한개 있는 경우에 대해서만 ? 씀
console.log(target.match(/se{0,1}oul/g));

/* |: or, []: or(문자 한글자) */
target = 'aa bb cc dd 123 456 _@';
console.log(target.match(/a|b/g)); // a 또는 b를 찾아줘
console.log(target.match(/[ab]/g)); // a or b를 찾아줘. []는 한글자를 의미. [] 안에 있는 것들중에 대해 or을 걸수 있다.
console.log(target.match(/a+|b+/g));   //a가 반복되거나, b가 반복되거나. 반복되는 단어 단위

/* 하이픈(-)은 아스키코드 또는 유니코드의 범위(대괄호에서 사용) */
console.log(target.match(/[a-z]/g));    // ' - ' 를 이용하여 a부터 z까지에 대해서 하나만 찾게 해주기 가능.
console.log('--------------------------------------');


/* \d: 숫자 */
console.log(target.match(/[0-9]+/g));
console.log(target.match(/\d+/g));      //위와 동일한 기능


/* \D: 숫자가 아닌 문자 */
console.log(target.match(/[^0-9]+/g));
console.log(target.match(/\D+/g));      //위와 동일한 기능

/*
   \w : 알파벳, 숫자 , 언더스코어(_)  == [a-z | A-Z | 0~9 | _ ]
   \W : 위를 제외한 나머지 == [^(a-z | A-Z | 0~9 | _)]
*/
console.log(target.match(/\w+/g));
console.log(target.match(/\W+/g));

/* ^: 시작위치([] 안에서는 not의 의미), $: 마지막 위치 */
target = 'https://www.google.com/https';
console.log(target.match(/^https/g));   // 시작부분
console.log(target.match(/https$/g));   // 종료부분


/* (): 그룹(한번에 고려될 묶음) */
target = 'test tesk tesa';
console.log(target.match(/test|tesk|tesa/g));
console.log(target.match(/tes(t|k|a)/g)); //위와 동일 [tka]로 해도 된다.    


target = 'RegExr was created by gskinner.com.';
console.log(target.match(/[a-zA-z.]+/g));   // 영어 또는 . 이들어간 문자가 하나라도 나오면. -> space x == 단어단위
console.log(target.match(/[a-zA-z.]+$/g));