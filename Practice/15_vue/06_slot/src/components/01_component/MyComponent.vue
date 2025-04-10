<template>
    <div>
        <h1 id="test">MyComponent</h1>
    </div>
</template>


<!-- script의 setup 키워드 덕에 setup() 함수 내부 코드만 작성해도 된다. -->
<!-- <script> -->
<script setup>
    import {onMounted} from 'vue';

    //export default {
    // setup() {
    onMounted(() => {
        console.log('MyComponent 부착!');
        let $idEle = document.getElementById('test');
        console.log($idEle);
    //  }
    // } 
    });
</script>

<style scoped>
    #test {
        color: blue;
    }
</style>