import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi"

// 查询房间信息列表
export function listRoom(query) {
  return request({
    url: '/system/room/list',
    method: 'get',
    params: query
  })
}

// 查询房间信息详细
export function getRoom(roomId) {
  return request({
    url: '/system/room/' + parseStrEmpty(roomId),
    method: 'get'
  })
}

// 新增房间信息
export function addRoom(data) {
  return request({
    url: '/system/room',
    method: 'post',
    data: data
  })
}

// 修改房间信息
export function updateRoom(data) {
  return request({
    url: '/system/room',
    method: 'put',
    data: data
  })
}

// 删除房间信息
export function delRoom(roomId) {
  return request({
    url: '/system/room/' + roomId,
    method: 'delete'
  })
}
