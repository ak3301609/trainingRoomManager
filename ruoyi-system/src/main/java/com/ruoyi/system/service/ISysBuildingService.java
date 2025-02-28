package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysBuilding;

/**
 * 建筑物信息Service接口
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
public interface ISysBuildingService 
{
    /**
     * 查询建筑物信息
     * 
     * @param buildingId 建筑物信息主键
     * @return 建筑物信息
     */
    public SysBuilding selectSysBuildingByBuildingId(Long buildingId);

    /**
     * 查询建筑物信息列表
     * 
     * @param sysBuilding 建筑物信息
     * @return 建筑物信息集合
     */
    public List<SysBuilding> selectSysBuildingList(SysBuilding sysBuilding);

    /**
     * 新增建筑物信息
     * 
     * @param sysBuilding 建筑物信息
     * @return 结果
     */
    public int insertSysBuilding(SysBuilding sysBuilding);

    /**
     * 修改建筑物信息
     * 
     * @param sysBuilding 建筑物信息
     * @return 结果
     */
    public int updateSysBuilding(SysBuilding sysBuilding);

    /**
     * 批量删除建筑物信息
     * 
     * @param buildingIds 需要删除的建筑物信息主键集合
     * @return 结果
     */
    public int deleteSysBuildingByBuildingIds(Long[] buildingIds);

    /**
     * 删除建筑物信息信息
     * 
     * @param buildingId 建筑物信息主键
     * @return 结果
     */
    public int deleteSysBuildingByBuildingId(Long buildingId);
}
