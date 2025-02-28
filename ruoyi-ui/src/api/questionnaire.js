import request from '@/utils/request'

export function init() {
    return request({
        url: '/system/log/wrongdata/init',
        method: 'get'
    })
}