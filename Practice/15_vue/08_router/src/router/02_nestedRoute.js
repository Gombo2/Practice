import {createRouter, createWebHistory} from 'vue-router';

import HomeView from '@/views/01_router/HomeView.vue';
import RootRouter from '@/views/02_nestedRoute/RootRouter.vue';
// import NestedHome from '@/views/02_nestedRoute/NestedHome.vue';
import NestedView from '@/views/02_nestedRoute/NestedView.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: HomeView
        },
        {
            path: '/nested',
            component: RootRouter,
            /* 중첩 라우팅에서 하위 컴포넌트를 위한 라우팅 에서는 path에 /(슬래시)를 쓰지 않아야 한다. */
            children: [
                {
                    // children부턴 /쓰면 안됨
                    path: 'home',
                    // component: NestedHome
                       
                    /* 
                        lazy loaded: 코드를 분할(청크)해서 필요한 시점에 가져옴으로 메모리 낭비를 줄이고,
                        속도 및 성능 향상을 도모할 수 있다.(코드 스플리팅)
                    */
                    component: () => import('@/views/02_nestedRoute/NestedHome.vue')
                },
                {
                    path: 'view',
                    component: NestedView
                }
            ]
        }
    ]
});


export default router;