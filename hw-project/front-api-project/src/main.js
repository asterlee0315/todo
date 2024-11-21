
import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import { useKakao } from 'vue3-kakao-maps/@utils';

useKakao('05a0b2e1278a2f4ddbfa4ed1b8990163');

const app = createApp(App)

app.use(createPinia())
app.use(router)

app.mount('#app')
