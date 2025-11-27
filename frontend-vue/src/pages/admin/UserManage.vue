<template>
  <div id="userManage">
    <div class="cord-container">
      <div class="form-space">
        <!--  搜索栏  -->
        <div class="search-dev">
          <a-form layout="inline" :model="searchParams" @click="doSearch">
            <a-form-item label="账户">
              <a-input placeholder="Please input ..." allow-clear />
            </a-form-item>
            <a-form-item label="用户名">
              <a-input placeholder="Please input ..." allow-clear />
            </a-form-item>
            <a-form-item>
              <a-button type="primary">Search</a-button>
            </a-form-item>
          </a-form>
          <div style="margin-bottom: 16px" />
        </div>
        <div class="btn-add">
          <a-button type="primary" @click="handleClick">添加用户</a-button>
          <a-modal v-model:visible="visible" title="Modal Form" @cancel="handleCancel" @before-ok="handleBeforeOk">
            <a-form :model="userAddForm">
              <a-form-item field="name" label="Account">
                <a-input v-model="userAddForm.userAccount" />
              </a-form-item>
              <a-form-item field="name" label="Nickname">
                <a-input-password v-model="userAddForm.userName" />
              </a-form-item>
              <a-form-item field="post" label="Post">
                <a-select v-model="userAddForm.userRole">
                  <a-option value="user">普通用户</a-option>
                  <a-option value="admin">管理员</a-option>
                </a-select>
              </a-form-item>
            </a-form>
          </a-modal>
        </div>
      </div>
      <a-table
          :columns="columns"
          :data-source="dataList"
          :pagination="pagination"
          @change="doTableChange"
      >
        <template #bodyCell="{ column, record }">
          <template v-if="column.dataIndex === 'userAvatar'">
            <a-image :src="record.userAvatar" :width="120" />
          </template>
          <template v-else-if="column.dataIndex === 'userRole'">
            <div v-if="record.userRole === 'admin'">
              <a-tag color="green">管理员</a-tag>
            </div>
            <div v-else>
              <a-tag color="blue">普通用户</a-tag>
            </div>
          </template>
          <template v-if="column.dataIndex === 'createTime'">
            {{ dayjs(record.createTime).format('YYYY-MM-DD HH:mm:ss') }}
          </template>
          <template v-else-if="column.key === 'action'">
            <a-button danger @click="doDelete(record.id)">删除</a-button>
          </template>
        </template>
      </a-table>
    </div>
  </div>
</template>

<script setup lang="ts">

import {computed, reactive, ref} from "vue";
import dayjs from "dayjs";

const columns = [
  {
    title: 'id',
    dataIndex: 'id',
  },
  {
    title: '账号',
    dataIndex: 'userAccount',
  },
  {
    title: '用户名',
    dataIndex: 'userName',
  },
  {
    title: '头像',
    dataIndex: 'userAvatar',
  },
  {
    title: '简介',
    dataIndex: 'userProfile',
  },
  {
    title: '用户角色',
    dataIndex: 'userRole',
  },
  {
    title: '创建时间',
    dataIndex: 'createTime',
  },
  {
    title: '操作',
    key: 'action',
  },
];

// 定义数据
const dataList = ref([])
const total = ref(0)

// 添加用户业务
const visible = ref(false);
const userAddForm = reactive({
  userAccount: '',
  userName: '',
  userAvatar: '',
  userProfile: '',
  userRole: 'user',
})
const handleClick = () => {
  visible.value = true;
}
const handleBeforeOk = (done: Function) => {
  console.log(userAddForm)
  window.setTimeout(() => {
    done()
    // prevent close
    // done(false)
  }, 3000)

};
const handleCancel = () => {
  visible.value = false;
}

/** ------------ 搜索业务 ------------ */
// 搜索条件
const searchParams = reactive({
  current: 1,
  pageSize: 10,
  sortField: "createTime",
  sortOrder: "ascend",
});



const fetchData = async () => {
  // const res = await ;o
}

// 分页参数
const pagination = computed(() => {
  return {
    current: searchParams.current,
    pageSize: searchParams.pageSize,
    total: total.value,
    showSizeChanger: true,
    showTotal: (total: number) => `共 ${total} 条`,
  }
})

// 表格变化之后，重新获取数据
const doTableChange = (page: any) => {
  searchParams.current = page.current
  searchParams.pageSize = page.pageSize
  fetchData()
}

// 搜索数据
const doSearch = () => {
  // 重置页码
  searchParams.current = 1
  fetchData()
}



// 删除数据
const doDelete = async (id: string) => {
  if (!id) {
    return
  }
  // const res = await deleteUserUsingPost({ id })
  // if (res.data.code === 0) {
  //   message.success('删除成功')
  //   // 刷新数据
  //   fetchData()
  // } else {
  //   message.error('删除失败')
  // }
}
</script>

<style scoped>
.form-space {
  display: flex;
  justify-content: space-between;
}
</style>