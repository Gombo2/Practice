<template>
 <header>
  <h1>Router 사용하기</h1>
  <hr>
  <div>
    <h2>basic router</h2>
    <nav>
      <!-- 기능이 있는 버튼(네비게이션이라고 생각) -->
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/pathvariable/1">PathVariable</RouterLink>
      <RouterLink to="/querystring?name=홍길동&age=20">QueryString</RouterLink>
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