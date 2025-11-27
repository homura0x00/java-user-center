import {createRouter, createWebHistory} from 'vue-router';
import LoginPage from "../pages/user/LoginPage.vue";
import HomePage from "../pages/HomePage.vue";
import UserManage from "../pages/admin/UserManage.vue";
import MainLayout from "../layouts/MainLayout.vue";
import AuthLayout from "../layouts/AuthLayout.vue";
import RegisterPage from "../pages/user/RegisterPage.vue";


export const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            component: MainLayout,
            children: [
                { path: '', component: HomePage },
                { path: 'userManage', name: '用户管理', component: UserManage },
            ]
        },
        {
            path: '/auth',
            component: AuthLayout,
            children: [
                { path: 'login', component: LoginPage },
                { path: 'register', component: RegisterPage },
            ]
        }
    ],
})
