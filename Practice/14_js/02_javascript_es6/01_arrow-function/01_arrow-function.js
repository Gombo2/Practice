/*
  1. 콜백 함수로 화살표 함수를 사용하게 되면 해당 화살표 함수가 사용하는 곳에 따라
   this의 의미가 정해진다.

   화살표 함수 : 렉시컬 this(화살표 함수는 자신만의 this를 가지지 않음)
                상위 스코프에서 상속 받아 화살표 함수가 정의된 시점의 상위 스코프 (여기서는 showMovieList)
                에서의 this를 의미하게 된다.

    단순 익명 함수: 자체 this의 의미가 바인딩 되어 있다.
                   콜백 함수로 쓰일 대는 기본적으로 global(전역 객체)를 의미하게 된다. 
*/

let theater = {
    store: '강남점',
    titles: ['승부', '브리짓 존스의 일기: 뉴 챕터', '진격의 거인', '미키17', '콘클라베'],
    showMovieList() {
        // 배열의 각 요소마다 forEach가 실행된다.
        this.titles.forEach(
            //  => 람다 사용시 this의 의미가 배열 객체를 가리킴
            title => console.log(this.store + ": " + title) // 화살표 함수의 쓰인 this는 원래 대상이 없다.
        );
    }

    // showMovieList() {
    //     this.titles.forEach(
    //         function(title) {
    //             console.log(this.store + ": " + title);     //foreach 안에서의 this의 의미 (전역객체)
    //         }
    //     );
    // }
};

theater.showMovieList();