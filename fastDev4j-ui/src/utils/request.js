import axios from 'axios'
import { ElMessage } from 'element-plus'

const service = axios.create({
  // baseURL: import.meta.env.VITE_BASE_API,
  timeout: 3000000 // request timeout
})

// 请求拦截器
service.interceptors.request.use(
  (config) => {
  
    // 如果有token 就携带tokon
    if (true) {
      config.headers['Authorization'] =  ''
    }
    console.log(config)
    if (config.url === '/api/utils/upload') {
      // config.headers['Content-Type'] = 'multipart/form-data'
      // config.data = qs.stringify(config.data, { indices: false, skipNulls: true })
    }
    // if (config.headers['Content-Type'] !== 'multipart/form-data') {
    //   config.data = qs.stringify(config.data, { indices: false, skipNulls: true })
    // }
    // 加上取消请求
    config.cancelToken = new axios.CancelToken((cancel) => {
      if (Array.isArray(window.axiosCancelTokenList)) {
        window.axiosCancelTokenList.push(cancel)
      } else {
        window.axiosCancelTokenList = [cancel]
      }
    })
    return config
  },
  (error) => Promise.reject(error)
)

// 响应拦截器
service.interceptors.response.use(
  (response) => response.data,
  (error) => {
    if (error.response && error.response.status === 401) {

    }
    ElMessage({
      type: 'error',
      message: error.msg
    })
    return Promise.reject(error)
  }
)

export default service
