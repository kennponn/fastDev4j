<template>  
    <div style="display: flex; align-items: center;  justify-content: center;width: 100%;height:100vh;">  
      <div class="register-container">  
        <h2>注册账号</h2>  
        <el-form ref="userRef" :model="form" :rules="rules" :validateError="handleValidationError" @validate="onValidate">  
          <el-form-item class="form-group">  
            <label>用户名:</label>  
            <el-input type="text" id="username" v-model="form.username" />  
          </el-form-item>  
          <el-form-item class="form-group">  
            <label>邮箱:</label>  
            <el-input type="email" v-model="form.email" />  
          </el-form-item>  
          <el-form-item class="form-group">  
            <label>密码:</label>  
            <el-input type="password" v-model="form.password" />  
          </el-form-item>  
          <el-button @click="onSubmit()">注册</el-button>  
        </el-form>  
        <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>  
        <p>已有帐号? <router-link to="/login">登录</router-link></p>  
      </div>  
    </div>  
  </template>  
    
  <script setup>  
  import { ElForm, ElInput, ElButton, ElMessage } from "element-plus";  
  import { ref, reactive } from "vue";  
import { register } from "../api/system";
    
  const form = reactive({  
    username: "",  
    password: "",  
    email: "",  
  });  
  const rules = reactive({  
    username: [  
      { required: true, message: "用户名称不能为空", trigger: "blur" },  
      { min: 2, max: 20, message: "用户名称长度必须介于 2 和 20 之间", trigger: "blur" },  
    ],  
    password: [  
      { required: true, message: "用户密码不能为空", trigger: "blur" },  
      { min: 5, max: 20, message: "用户密码长度必须介于 5 和 20 之间", trigger: "blur" },  
    ],  
    email: [  
      { type: "email", message: "请输入正确的邮箱地址", trigger: ["blur", "change"] },  
    ],  
  });  
    
  const errorMessage = ref("");  
  const handleValidationError = (error) => {  
    errorMessage.value = error.msg; // 这里将错误消息赋值给 errorMessage，以便在模板中显示它。  
  };  
    
  const onValidate = (valid) => {  
    if (valid) {  
      onSubmit();  
    } else {  
      ElMessage.error("表单验证失败"); // 这里显示默认的错误消息。你可以根据需要自定义这个消息。  
    }  
  };  
    
  const onSubmit = () => {  
    register(form).then((res) => {  
      alert(res.msg);  
    });  
  };  
  </script>
  <style scoped>
  .register-container {
    width: 500px;
   
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
  