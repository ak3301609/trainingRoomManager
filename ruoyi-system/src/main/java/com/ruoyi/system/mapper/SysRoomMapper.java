package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRoom;

/**
 * 房间信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
public interface SysRoomMapper 
{
    /**
     * 查询房间信息
     * 
     * @param roomId 房间信息主键
     * @return 房间信息
     */
    public SysRoom selectSysRoomByRoomId(Long roomId);

    /**
     * 查询房间信息列表
     * 
     * @param sysRoom 房间信息
     * @return 房间信息集合
     */
    public List<SysRoom> selectSysRoomList(SysRoom sysRoom);

    /**
     * 新增房间信息
     * 
     * @param sysRoom 房间信息
     * @return 结果
     */
    public int insertSysRoom(SysRoom sysRoom);

    /**
     * 修改房间信息
     * 
     * @param sysRoom 房间信息
     * @return 结果
     */
    public int updateSysRoom(SysRoom sysRoom);

    /**
     * 删除房间信息
     * 
     * @param roomId 房间信息主键
     * @return 结果
     */
    public int deleteSysRoomByRoomId(Long roomId);

    /**
     * 批量删除房间信息
     * 
     * @param roomIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRoomByRoomIds(Long[] roomIds);
}
