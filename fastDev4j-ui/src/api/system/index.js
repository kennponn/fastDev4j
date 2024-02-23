import request from '@/utils/request'

/**
 * 登录
 * @param {*} data
 * @returns
 */
export function login(param) {
    return request({
      url: '/api/login',
      method: 'get',
      params:param
    })
  }
  /**
   * 注销
   * @returns
   */
  export function logout() {
    return request({
      url: '/api/logout',
      method: 'get'
    })
  }