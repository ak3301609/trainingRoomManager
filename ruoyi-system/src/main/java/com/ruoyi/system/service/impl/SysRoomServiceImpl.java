package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRoomMapper;
import com.ruoyi.system.domain.SysRoom;
import com.ruoyi.system.service.ISysRoomService;

/**
 * 房间信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
@Service
public class SysRoomServiceImpl implements ISysRoomService 
{
    @Autowired
    private SysRoomMapper sysRoomMapper;

    /**
     * 查询房间信息
     * 
     * @param roomId 房间信息主键
     * @return 房间信息
     */
    @Override
    public SysRoom selectSysRoomByRoomId(Long roomId)
    {
        return sysRoomMapper.selectSysRoomByRoomId(roomId);
    }

    /**
     * 查询房间信息列表
     * 
     * @param sysRoom 房间信息
     * @return 房间信息
     */
    @Override
    public List<SysRoom> selectSysRoomList(SysRoom sysRoom)
    {
        return sysRoomMapper.selectSysRoomList(sysRoom);
    }

    /**
     * 新增房间信息
     * 
     * @param sysRoom 房间信息
     * @return 结果
     */
    @Override
    public int insertSysRoom(SysRoom sysRoom)
    {
        sysRoom.setCreateTime(DateUtils.getNowDate());
        return sysRoomMapper.insertSysRoom(sysRoom);
    }

    /**
     * 修改房间信息
     * 
     * @param sysRoom 房间信息
     * @return 结果
     */
    @Override
    public int updateSysRoom(SysRoom sysRoom)
    {
        sysRoom.setUpdateTime(DateUtils.getNowDate());
        return sysRoomMapper.updateSysRoom(sysRoom);
    }

    /**
     * 批量删除房间信息
     * 
     * @param roomIds 需要删除的房间信息主键
     * @return 结果
     */
    @Override
    public int deleteSysRoomByRoomIds(Long[] roomIds)
    {
        return sysRoomMapper.deleteSysRoomByRoomIds(roomIds);
    }

    /**
     * 删除房间信息信息
     * 
     * @param roomId 房间信息主键
     * @return 结果
     */
    @Override
    public int deleteSysRoomByRoomId(Long roomId)
    {
        return sysRoomMapper.deleteSysRoomByRoomId(roomId);
    }
}
