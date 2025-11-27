<template>
  <div id="loginPage">
      <a-space direction="vertical" size="large" :style="{width: '600px'}">
        <a-form :model="form" layout="vertical" @submit="handleSubmit">
          <a-form-item>
            <a-input v-model="form.userAccount" placeholder="please enter your username..." >
              <template #prefix>
                <icon-user />
              </template>
            </a-input>
          </a-form-item>
          <a-form-item>
            <a-input-password
                v-model="form.userPassword"
                placeholder="Please enter something"
                :defaultVisibility="true"
                allow-clear
            >
              <template #prefix>
                <icon-lock />
              </template>
            </a-input-password>
          </a-form-item>
          <a-form-item class="form-btn">
            <a-button html-type="submit" type="primary" :style="{width: '100%'}">登陆</a-button>
          </a-form-item>
        </a-form>
      </a-space>
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue';

const form = reactive({
  userAccount: '',
  userPassword: '',
  isRead: false,
})

const handleSubmit = async (data: any) => {
  console.log(data);
}

</script>


<style scoped>

#loginPage {
  display: flex;
  justify-content: center;
  align-items: center;
}


</style>