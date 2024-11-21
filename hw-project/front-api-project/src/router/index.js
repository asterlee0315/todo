import { createRouter, createWebHistory } from 'vue-router'
import KakaoView from '@/views/KakaoView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
  
    {
      path:"/kakao",
      name:"kakao",
      component: KakaoView
    }
  ],
})

export default router
