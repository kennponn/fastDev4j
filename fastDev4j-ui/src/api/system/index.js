import request from '@/utils/request'

/**
 * 注册
 * @param {*} data
 * @returns
 */
export function register(param) {
    return request({
      url: '/api/user/list',
      method: 'get',
      data:param
    })
  }