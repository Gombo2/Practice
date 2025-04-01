function outer() {
    var outerVal = '외부함수';


    function inner() {
        var innerVal = '내부 함수';
        console.log(outerVal, innerVal);
    }

    inner();
}

// inner();    // 내부 함수는 외부에서 접근 불가.
outer();