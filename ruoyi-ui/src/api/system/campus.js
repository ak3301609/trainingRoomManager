import request from '@/utils/request'

// 查询校区信息列表
export function listCampus(query) {
  return request({
    url: '/system/campus/list',
    method: 'get',
    params: query
  })
}

// 查询校区信息详细
export function getCampus(campusId) {
  return request({
    url: '/system/campus/' + campusId,
    method: 'get'
  })
}

// 新增校区信息
export function addCampus(data) {
  return request({
    url: '/system/campus',
    method: 'post',
    data: data
  })
}

// 修改校区信息
export function updateCampus(data) {
  return request({
    url: '/system/campus',
    method: 'put',
    data: data
  })
}

// 删除校区信息
export function delCampus(campusId) {
  return request({
    url: '/system/campus/' + campusId,
    method: 'delete'
  })
}
