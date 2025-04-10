<!-- 
    Props와 Slot의 차이점
    Props는 부모가 자식에게 데이터를 전달할 때 사용
    Slot은 부모가 자식에게 태그를 전달할 때 사용

    Prop는 기본적으로 read-only의 개념을 통해 자식
    컴포넌트에서 수정해도 부모에 영향을 주지 않아야 한다.
    (안티 패턴 방지)
-->


<template>
    <div :class="{container: true, dark: darkState}">
        <!-- 물려줄걸 child옆에 :~형식으로 가능 -->
        <!-- 원하는 이름으로 부모 컴포넌트의 데이터를 전달할 수 있다.(일반적으로는 같은 이름을 사용하는 편이다.) -->
        <PropsChild :message="message2"/>

        <!-- props는 아니지만, 직접 사용자 정의형 이벤트인 toggle과 함께 toggleDarkMode라는 이벤트 핸들러 함수도 물려줌 -->
        <!-- props는 아니지만 직접 사용자 정의형 이벤트인 toggle을 물려줌  -->
        <DarkMode @toggle="toggleDarkMode"/>

    </div>
</template>

<script setup>
    import PropsChild from './PropsChild.vue';
    import DarkMode from './DarkMode.vue';

    import { ref } from 'vue';

    const message2 = ref('hello');
    const darkState = ref(false);
    
    function toggleDarkMode() {
        darkState.value = !darkState.value;
    }
</script>

<style  scoped>
    .container{
        border: 1px solid;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .dark{
        background-color: black;
        color: white;
    }
</style>