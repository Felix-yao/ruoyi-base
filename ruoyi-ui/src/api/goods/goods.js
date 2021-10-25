import request from '@/utils/request'

// 查询货物列表
export function listGoods(query) {
  return request({
    url: '/goods/goods/list',
    method: 'get',
    params: query
  })
}

// 查询货物详细
export function getGoods(id) {
  return request({
    url: '/goods/goods/' + id,
    method: 'get'
  })
}

// 新增货物
export function addGoods(data) {
  return request({
    url: '/goods/goods',
    method: 'post',
    data: data
  })
}

// 修改货物
export function updateGoods(data) {
  return request({
    url: '/goods/goods',
    method: 'put',
    data: data
  })
}

// 删除货物
export function delGoods(id) {
  return request({
    url: '/goods/goods/' + id,
    method: 'delete'
  })
}

// 导出货物
export function exportGoods(query) {
  return request({
    url: '/goods/goods/export',
    method: 'get',
    params: query
  })
}