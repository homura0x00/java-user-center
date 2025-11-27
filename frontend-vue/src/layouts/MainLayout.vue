<template>
  <div id="MainLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header">
        <GlobalHeader />
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer">
        <a href="https://github.com/rabitIII" target="_blank">多兔 by homura</a>
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<script setup lang="ts">
import GlobalHeader from "../components/GlobalHeader.vue";

</script>

<style scoped>
#MainLayout :deep(.arco-layout-header),
#MainLayout :deep(.arco-layout-footer),
#MainLayout :deep(.arco-layout-sider-children),
#MainLayout :deep(.arco-layout-content) {
  display: flex;
  flex-direction: column;
  font-size: 16px;
  font-stretch: condensed;
  text-align: center;
}

#MainLayout .header {
  padding-inline: 20px;
  background: white;
  color: unset;
  margin-bottom: 1px;
}

#MainLayout :deep(.acro-menu-root) {
  border-bottom: none !important;
  border-inline-end: none !important;
}

#MainLayout .content {
  padding: 28px;
  background: linear-gradient(to right, #fefefe, #fff);
  margin-bottom: 28px;
}

#MainLayout .footer {
  background: #efefef;
  padding: 16px;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
}
</style>