import {createRouter, createWebHashHistory, createWebHistory} from 'vue-router';
import HomeView from '@/views/01_router/HomeView.vue'
import PathVariable from '@/views/01_router/PathVariable.vue';
import QueryString from '@/views/01_router/QueryString.vue';

/*
    createWebHistory vs createWebHashHistory
    - createWebHashHistory는 중간 경로에 '#'을 붙여주어 백엔드 서버로의 통신이 아닌 클라이언트 라우팅을 위한 url 경로 주소임을
    구분하기 위해 사용된다.
    - createWebHistory는 경로가 클라이언트 서버 주소 뒤에 직접 위치한다.  
*/

const router = createRouter({
    // history: createWebHashHistory(),
    history: createWebHistory(), // hash 모드가 아닌 모드로 사용하고 싶다면 이걸 사용하자.
    routes: [
        {
            path: '/',
            component: HomeView 
        },
        {   
            /* pathvariable 형태의 라우팅은 경로상의 값을 받아줄 변수를 작성하는 형태로 설정해야 한다. */
            path: '/pathvariable/:id',
            component: PathVariable
        },
        { 
            path: '/queryString',
            component: QueryString
        }
    ]
});

export default router;