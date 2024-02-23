import axios from 'axios'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'

const router = useRouter()
const service = axios.create({
  // baseURL: import.meta.env.VITE_BASE_API,
  timeout: 3000000 // request timeout
})

// 请求拦截器
service.interceptors.request.use(
  (config) => {
    var token = localStorage.getItem('token')
    // 如果有token 就携带tokon
    if (token) {
      config.headers['Authorization'] =  token
    }
    return config
  },
  (error) => Promise.reject(error)
)

// 响应拦截器
service.interceptors.response.use(
  (response) => response.data,
  (error) => {
   
    if (error.response.data && error.response.status == 401) {
      ElMessage({
        type: 'error',
        message: error.response.data.msg
      })
      window.location.href = '/login'
      
    }
    if (error.response.data && error.response.status == 500) {
      ElMessage({
        type: 'error',
        message: "请求失败，请稍后再试"
      })
    }
   
    return Promise.reject(error)
  }
)

export default service
