<template>
 <header>
  <h1>Router 사용하기</h1>
  <hr>
  <div>
    <!-- 기능이 있는 버튼(네비게이션이라고 생각) -->
    <!-- 
      RouterLink
      1. to 속성을 쓰면 url 주소를 바꿔준다.(라우팅, location.href 속성을 바꾸는 것과 같은 작업(url 경로 수정))
      2. active-class를 쓰면 사용자가 활성화한 버튼에 클래스명으로 css를 별도로 부여할 수 있다.
      3. replace를 쓰면 뒤로 가기를 막는 효과를 낼 수도 있다.
      -->
    <!-- <h2>basic router</h2>
    <nav>
      <RouterLink to="/" active-class="active" replace>Home</RouterLink>
      <RouterLink to="/pathvariable/1" active-class="active" replace>PathVariable</RouterLink>
      <RouterLink to="/querystring?name=홍길동&age=20" active-class="active" replace>QueryString</RouterLink>
    </nav> -->

    <h2>nested router</h2>
    <nav>
      <RouterLink to="/" active-class="active" replace>Home</RouterLink>
      <RouterLink to="/nested/home" active-class="active" replace>중첩 HOME</RouterLink>
      <RouterLink to="/nested/view" active-class="active" replace>중첩 VIEW</RouterLink>
    </nav>
  </div>
 </header>
 <main>
    <RouterView/>
 </main>
</template>

<script setup>
// RouterView -> 라우터에 의해 렌더링되는 컴포넌트
// RouterLink -> 라우터를 통해 이동할 수 있는 링크를 생성하는 컴포넌트
  import {RouterLink, RouterView} from 'vue-router';
</script>

<style scoped>
   nav {
    width: 100%;
    font-size: 12px;
    text-align: center;
    margin-top: 2rem;
    font-size: 30px;
  }

  a {
    margin-left: 10px;
  }

  .active {
    color: red;
    text-decoration: none;
  }

  main {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  header {
    text-align: center;
  }
</style>