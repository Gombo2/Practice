/*
  UTC(협정 세계시): 국제 표준시로 기술적 표기에 사용된다.(영국 런던 기준)
  GMT(그리니치 평균시) : UTC와 소수점 단위 점도의 초가 차이나지만, 일상 생활에는 지장 X
  KST(한국 표준시) : UTC + 9 시간
*/

/* 1. new Date() */
console.log(new Date());    // UTC상으로 1970년 1월 1일 0시 기준
console.log(new Date(0));   // 1970년 기준이기에 안흐른 기준이 나옴.
console.log(Date());        // 함수가 호출되고 객체 생성은 안되지만 시스템 현재시간이 반환됨.

console.log(new Date(1000 * 60 * 60 * 24));

console.log(new Date(2025, 4));   // 0 ~ 11을 활용한 월(month) 체계를 가지고 있음.
console.log(new Date(2025, (4 - 1), 2, (12 + 9), 9, 0)); // 년, 월, 일, 시, 분, 초 (9시간 차이남 UTC와)

/* 밀리초 까지 넣을수 있고, 원하는 만큼의 인수로 전달하면
   UTC 기준 Date 객체가 반환(9시간 전)
*/