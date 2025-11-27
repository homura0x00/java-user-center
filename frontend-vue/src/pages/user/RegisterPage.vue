<template>
  <div id="register-form">
    <a-space direction="vertical" size="large" :style="{width: '600px'}">
      <a-form :model="form" layout="vertical" @submit="handleSubmit">
        <a-form-item field="name" label="账户">
          <a-input v-model="form.userAccount" placeholder="please enter your account..." />
        </a-form-item>
        <a-form-item field="post" label="密码">
          <a-input-password v-model="form.userPassword" placeholder="please enter your password..." />
        </a-form-item>
        <a-form-item field="post" label="二次密码">
          <a-input-password v-model="form.checkPassword" placeholder="please enter your password..." />
        </a-form-item>
        <a-form-item>
          <a-button html-type="submit" type="primary" :style="{width: '100%'}">注册</a-button>
        </a-form-item>
      </a-form>
    </a-space>
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue';
import {Form} from "@arco-design/web-vue";

const form = reactive({
  userAccount: '',
  userPassword: '',
  checkPassword: '',
})

const handleSubmit = async (form: Form) => {
  console.log(form)
}
</script>

<style scoped>
#register-form {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>