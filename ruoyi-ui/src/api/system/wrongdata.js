import request from '@/utils/request'

// 查询实训室登记记录列表
export function listLog(query) {
  return request({
    url: '/system/log/wrongdata/list',
    method: 'get',
    params: query
  })
}

// 查询实训室登记记录详细
export function getLog(wrongdataId) {
  return request({
    url: '/system/log/wrongdata/' + wrongdataId,
    method: 'get'
  })
}

// 新增实训室登记记录
export function addLog(data) {
  return request({
    url: '/system/log/wrongdata',
    method: 'post',
    data: data
  })
}

// 修改实训室登记记录
export function updateLog(data) {
  return request({
    url: '/system/log/wrongdata',
    method: 'put',
    data: data
  })
}

// 删除实训室登记记录
export function delLog(wrongdataId) {
  return request({
    url: '/system/log/wrongdata/' + wrongdataId,
    method: 'delete'
  })
}
