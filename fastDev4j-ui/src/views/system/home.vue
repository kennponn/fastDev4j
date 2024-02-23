<template>
  <div>
    <button @click="onSubmit">登录</button>
  </div>
</template>

<script setup>
import { logout } from '@/api/system'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
const router = useRouter()
const onSubmit = () => {
  logout().then((response) => {
    if(response.code==200){
      ElMessage.success(response.msg);
      localStorage.removeItem("token");
      router.push("/login");
    }else
      ElMessage.error(response.msg);
  });
}; 
</script>

<style scoped>
/* Your component styles here */
</style>
