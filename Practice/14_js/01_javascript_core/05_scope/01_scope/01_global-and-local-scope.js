var x = 'global x';
var y = 'global y';

function outer() {
    var z = "outer's local z";

    console.log(x);
    console.log(y);
    console.log(z);

    function inner() {
        var x = "inner's local x";
        
        console.log(x);
        console.log(y);
        console.log(z);
    }

    inner();
}

outer();

/*
  스코프 체인

  inner 스코프를 -> outer 스코프 -> 전역 스코프 순으로 우선순위가 결정된다.
  모든 스코프는 하나의 계층적 구조로 연결되며 자바 스크립트 엔진은 스코프 체인을 통해
  변수를 참조하는 코드의 스코프에서 상위 스코프 방향으로 이동하며 선언된 변수를 참조한다.
  (하위 스코프에서 유효한 변수를 사우이 스코프에서는 참조할 수 없다.)
*/