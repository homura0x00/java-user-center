<template>
  <div id="global-header">
    <a-row :wrap="false">
      <a-col flex="200px">
        <router-link to="/">
          <div class="title-bar">
            <img class="logo" src="../assets/vue.svg" alt="logo" />
            <div class="title">User Center</div>
          </div>
        </router-link>
      </a-col>
      <a-col flex="auto">
        <a-menu
            v-model:selected-keys="current"
            mode="horizontal"
            @menuItemClick="doMenuClick">
          <a-menu-item key="/">主页</a-menu-item>
          <a-menu-item key="/userManage">用户管理</a-menu-item>
        </a-menu>
      </a-col>
      <a-col flex="120px">
        <div class="user-login-status">
          <div v-if="loginUserStore.loginUser.id">
            <a-dropdown>
              <a-space>
                <a-avatar :src="loginUserStore.loginUser.userAvatar" />
                {{ loginUserStore.loginUser.userName ?? '无名' }}
              </a-space>
              <template #overlay>
                <a-menu>
                  <a-menu-item>
                    <router-link to="/my_space">
                      <icon-user />
                      我的空间
                    </router-link>
                  </a-menu-item>
                  <a-menu-item @click="doLogout">
                    <icon-export />
                    退出登录
                  </a-menu-item>
                </a-menu>
              </template>
            </a-dropdown>
          </div>
        </div>
      </a-col>
    </a-row>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import {useRouter, useRoute} from "vue-router";
import {useLoginUserStore} from "../store/useLoginUserStore.ts";

const loginUserStore = useLoginUserStore()

const router = useRouter()
const route = useRoute()

// 当前要高亮的菜单项
const current = ref<string[]>([route.path])
// 监听路由变化，更新高亮菜单项
router.afterEach((to, _from, _next) => {
  current.value = [to.path]
  console.log(current.value)
})

// 路由跳转事件
const doMenuClick = (key: string) => {
  router.push({
    path: key,
  })
}

// 用户注销
const doLogout = async () => {
  // const res = await userLogoutUsingPost()
  // if (res.data.code === 0) {
  //   loginUserStore.setLoginUser({
  //     userName: '未登录',
  //   })
  //   message.success('退出登录成功')
  //   await router.push('/user/login')
  // } else {
  //   message.error('退出登录失败，' + res.data.message)
  // }
}
</script>

<style scoped>
#global-header .title-bar {
  margin: 18px;
  display: flex;
  align-items: center;
}

.title {
  color: black;;
  font-size: 18px;
  margin-left: 5px;
}

.logo {
  height: 38px;
}
</style>