package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysBuildingMapper;
import com.ruoyi.system.domain.SysBuilding;
import com.ruoyi.system.service.ISysBuildingService;

/**
 * 建筑物信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
@Service
public class SysBuildingServiceImpl implements ISysBuildingService 
{
    @Autowired
    private SysBuildingMapper sysBuildingMapper;

    /**
     * 查询建筑物信息
     * 
     * @param buildingId 建筑物信息主键
     * @return 建筑物信息
     */
    @Override
    public SysBuilding selectSysBuildingByBuildingId(Long buildingId)
    {
        return sysBuildingMapper.selectSysBuildingByBuildingId(buildingId);
    }

    /**
     * 查询建筑物信息列表
     * 
     * @param sysBuilding 建筑物信息
     * @return 建筑物信息
     */
    @Override
    public List<SysBuilding> selectSysBuildingList(SysBuilding sysBuilding)
    {
        return sysBuildingMapper.selectSysBuildingList(sysBuilding);
    }

    /**
     * 新增建筑物信息
     * 
     * @param sysBuilding 建筑物信息
     * @return 结果
     */
    @Override
    public int insertSysBuilding(SysBuilding sysBuilding)
    {
        sysBuilding.setCreateTime(DateUtils.getNowDate());
        return sysBuildingMapper.insertSysBuilding(sysBuilding);
    }

    /**
     * 修改建筑物信息
     * 
     * @param sysBuilding 建筑物信息
     * @return 结果
     */
    @Override
    public int updateSysBuilding(SysBuilding sysBuilding)
    {
        sysBuilding.setUpdateTime(DateUtils.getNowDate());
        return sysBuildingMapper.updateSysBuilding(sysBuilding);
    }

    /**
     * 批量删除建筑物信息
     * 
     * @param buildingIds 需要删除的建筑物信息主键
     * @return 结果
     */
    @Override
    public int deleteSysBuildingByBuildingIds(Long[] buildingIds)
    {
        return sysBuildingMapper.deleteSysBuildingByBuildingIds(buildingIds);
    }

    /**
     * 删除建筑物信息信息
     * 
     * @param buildingId 建筑物信息主键
     * @return 结果
     */
    @Override
    public int deleteSysBuildingByBuildingId(Long buildingId)
    {
        return sysBuildingMapper.deleteSysBuildingByBuildingId(buildingId);
    }
}
