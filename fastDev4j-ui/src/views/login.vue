<template>
  <div
    style="
      display: flex;
      align-items: center;
      justify-content: center;
      width: 100%;
      height: 100vh;
      background-image: url(/src/assets/imgs/bg.jpg);
    "
  >
    <div class="register-container">
      <h2>注册账号</h2>
      <el-form ref="userRef" :model="form" :rules="rules">
        <el-form-item class="form-group" prop="username">
          <label>用户名:</label>
          <el-input type="text" id="username" v-model="form.username" />
        </el-form-item>

        <el-form-item class="form-group" prop="password">
          <label>密码:</label>
          <el-input type="password" v-model="form.password" />
        </el-form-item>
        <el-button @click="onSubmit()">登录</el-button>
      </el-form>
      <p v-if="errorMessage" style="color: red">{{ errorMessage }}</p>
      <p>还没有帐号? <router-link to="/login">立即注册</router-link></p>
    </div>
  </div>
</template>

<script setup>
import { ElForm, ElInput, ElButton, ElMessage } from "element-plus";
import { ref, reactive } from "vue";
import { register } from "@/api/system";

const form = reactive({
  username: "",
  password: "",
});
const rules = reactive({
  username: [
    { required: true, message: "用户名称不能为空", trigger: "blur" },
    { min: 5, max: 20, message: "用户名称长度必须介于 5 和 20 之间", trigger: "blur" },
  ],
  password: [
    { required: true, message: "用户密码不能为空", trigger: "blur" },
    { min: 5, max: 20, message: "用户密码长度必须介于 5 和 20 之间", trigger: "blur" },
  ],
});

const errorMessage = ref("");

const userRef = ref(null);
const onSubmit = () => {
  if (userRef.value) {
    userRef.value.validate((valid) => {
      if (valid) {
        register().then((response) => {
          ElMessage.success(response.msg);
        });
      } else {
        return false;
      }
    });
  } else {
    console.error("userRef is null");
  }
};
</script>
<style scoped>
.register-container {
  width: 500px;
  background-color: #fff;
  margin: auto;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  text-align: center;
}

form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 15px;
  text-align: left;
}

label {
  font-weight: bold;
  display: block;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
  margin-top: 5px;
}

button {
  background-color: #3498db; /* 蓝色 */
  color: #fff;
  padding: 10px;
  font-size: 18px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #2980b9; /* 深蓝色 */
}

p {
  margin-top: 15px;
  font-size: 14px;
}

router-link {
  color: #3498db;
  text-decoration: underline;
  cursor: pointer;
}
</style>
