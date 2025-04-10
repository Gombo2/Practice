<!-- 
    뷰는 기본적으로 자식 컴포넌트에서 부모 컴포넌트로부터 전달받는 props를 직접 수정해도
    부모 컴포넌트에 있는 데이터가 수정되지 않게 한다. (read-only 개념)
-->

<template>
    <div>
        <h1> {{  props.readValue  }}</h1>
        자식의 readValue: <input type="text" v-model="props.readValue"> 
    </div>
</template>

<script setup>
    import { defineProps } from 'vue';

    // 부모로부터 전달받은 props를 활용하기 위한 props 정의
    const props = defineProps({
        readValue: String
    });
</script>

<style scoped>

</style>