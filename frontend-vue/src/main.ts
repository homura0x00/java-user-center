import { createApp } from 'vue'
import App from './App.vue'
import AcroVue from '@arco-design/web-vue'
import ArcoVueIcon from '@arco-design/web-vue/es/icon';
import '@arco-design/web-vue/dist/arco.css';
import {router} from "./router";
import {createPinia} from "pinia";

const app = createApp(App);
app.use(createPinia());
app.use(AcroVue);
app.use(ArcoVueIcon);
app.use(router);

app.mount('#app')
