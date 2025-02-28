import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询建筑物信息列表
export function listBuilding(query) {
  return request({
    url: '/system/building/list',
    method: 'get',
    params: query
  })
}

// 查询建筑物信息详细
export function getBuilding(buildingId) {
  return request({
    url: '/system/building/' + parseStrEmpty(buildingId),
    method: 'get'
  })
}

// 新增建筑物信息
export function addBuilding(data) {
  return request({
    url: '/system/building',
    method: 'post',
    data: data
  })
}

// 修改建筑物信息
export function updateBuilding(data) {
  return request({
    url: '/system/building',
    method: 'put',
    data: data
  })
}

// 删除建筑物信息
export function delBuilding(buildingId) {
  return request({
    url: '/system/building/' + buildingId,
    method: 'delete'
  })
}
