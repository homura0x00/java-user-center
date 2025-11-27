<template>
  <div id="authLayout">
    <div class="auth-background">
      <div class="bg-pattern"></div>
      <div class="bg-gradient"></div>
    </div>

    <div class="auth-container">
      <!-- 左侧品牌展示区（1/3 宽度） -->
      <div class="auth-brand">
        <h1 class="brand-logo">Auth<span>App</span></h1>
        <p class="brand-desc">
          安全、高效的身份验证系统，为您的应用保驾护航
        </p>
        <div class="brand-illustration">
          <!-- 轻量 SVG 插图（比图片资源更小） -->
          <svg width="280" height="220" viewBox="0 0 280 220" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M70 40L140 20L210 40L240 100L210 160L140 180L70 160L40 100L70 40Z" stroke="currentColor" stroke-width="2" stroke-opacity="0.3"/>
            <path d="M70 70L140 50L210 70L220 110L210 150L140 170L70 150L60 110L70 70Z" stroke="currentColor" stroke-width="2" stroke-opacity="0.5"/>
            <circle cx="140" cy="110" r="30" stroke="currentColor" stroke-width="2" fill="currentColor" fill-opacity="0.1"/>
            <circle cx="140" cy="110" r="10" fill="currentColor" fill-opacity="0.3"/>
          </svg>
        </div>
      </div>
      <div class="auth-form-card">

        <div class="auth-form-cart-title">
          <div v-if="isLoginPage">Login</div>
          <div v-else>Register</div>
        </div>
        <!-- 路由视图：嵌入独立的登录/注册页面 -->
        <router-view v-slot="{ Component }">
          <transition name="fade" mode="out-in">
            <component :is="Component" class="form-content" />
          </transition>
        </router-view>

        <!-- 动态切换按钮：根据当前路由显示不同文本 -->
        <div class="auth-switch-btn">
          <router-link
              :to="isLoginPage ? '/auth/register' : '/auth/login'"
              class="switch-btn"
          >
            <span v-if="isLoginPage">没有账号？</span>
            <span v-else>已有账号？</span>
            <span class="highlight">{{ isLoginPage ? '去注册' : '去登录' }}</span>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import { computed } from 'vue';

// 获取当前路由
const route = useRoute();

// 计算当前是否为登录页（用于动态显示按钮文本）
const isLoginPage = computed(() => route.path === '/auth/login');
</script>

<style scoped>
#authLayout {
  position: relative;
  width: 100vw;
  height: 100vh;
  overflow: hidden;
  font-family: 'Inter', system-ui, sans-serif;
}

.auth-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 0;
  background-color: #f8fafc; /* 基础底色 */
}

/* 轻量图案层（CSS 生成，无图片资源） */
.bg-pattern {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image:
      radial-gradient(rgba(66, 153, 225, 0.1) 1px, transparent 1px),
      radial-gradient(rgba(66, 153, 225, 0.05) 1px, transparent 1px);
  background-size: 50px 50px;
  background-position: 0 0, 25px 25px;
  animation: patternMove 20s linear infinite;
}

/* 渐变叠加层（增强层次感） */
.bg-gradient {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(135deg, rgba(248, 250, 252, 0.8) 0%, rgba(234, 243, 250, 0.6) 100%);
}

/* 图案缓慢移动动画（动态感） */
@keyframes patternMove {
  0% {
    background-position: 0 0, 25px 25px;
  }
  100% {
    background-position: 50px 50px, 75px 75px;
  }
}

/* 主内容容器（响应式 2/3-1/3 布局） */
.auth-container {
  position: relative;
  z-index: 1;
  width: 100%;
  height: 100%;
  max-width: 1400px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 1fr 2fr; /* 1/3 和 2/3 分区 */
  align-items: center;
  padding: 0 2rem;
}

/* 左侧品牌展示区 */
.auth-brand {
  color: #1e293b;
  padding: 2rem;
}

.brand-logo {
  font-size: 2.5rem;
  font-weight: 700;
  margin-bottom: 1.5rem;
}

.brand-logo span {
  color: #3b82f6;
}

.brand-desc {
  font-size: 1.1rem;
  color: #64748b;
  line-height: 1.6;
  margin-bottom: 2rem;
  max-width: 300px;
}

.brand-illustration {
  color: #3b82f6;
  opacity: 0.7;
  transform: translateY(10px);
}

/* 右侧表单卡片 */
.auth-form-card {
  background: white;
  border-radius: 1.25rem;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.05);
  padding: 3rem;
  max-width: 400px;
  width: 100%;
  margin-left: auto;
  margin-right: auto;
  height: 500px;
  position: relative;
}

.auth-form-cart-title {
  margin: 1rem auto;
  text-align: center;
  width: 100%;
  font-size: 1.5rem;
  font-weight: 700;
}

/* 切换标签样式 */
/* 动态切换按钮样式（替换原 auth-tabs） */
.auth-switch-btn {
  display: flex;
  justify-content: center; /* 按钮靠右对齐 */
  margin-bottom: 1.5rem;
  position: absolute;
  left: 0;
  right: 0;
  bottom: 0;
}

.switch-btn {
  font-size: 0.95rem;
  color: #64748b;
  text-decoration: none;
  font-weight: 500;
  transition: color 0.3s ease;
}

.switch-btn:hover {
  color: #3b82f6;
}

/* 高亮文本（按钮中的核心文字） */
.switch-btn .highlight {
  color: #3b82f6;
  font-weight: 600;
  margin-left: 0.3rem;
}

/* 可选：如果需要按钮样式（而非文字链接），可替换为以下样式 */
/*
.switch-btn {
  padding: 0.5rem 1rem;
  border: 1px solid #3b82f6;
  border-radius: 0.75rem;
  font-size: 0.95rem;
  color: #3b82f6;
  text-decoration: none;
  font-weight: 600;
  transition: all 0.3s ease;
}

.switch-btn:hover {
  background: #3b82f6;
  color: white;
}
 */

/* 响应式适配 */
@media (max-width: 1024px) {
  .auth-container {
    grid-template-columns: 1fr; /* 移动端垂直布局 */
    padding: 2rem 1rem;
  }

  .auth-brand {
    display: none; /* 移动端隐藏品牌区 */
  }

  .auth-form-card {
    margin: 0 auto;
    padding: 2rem;
    max-width: 90%;
  }
}

@media (max-width: 640px) {
  .auth-form-card {
    padding: 1.5rem;
    border-radius: 1rem;
  }
}
</style>