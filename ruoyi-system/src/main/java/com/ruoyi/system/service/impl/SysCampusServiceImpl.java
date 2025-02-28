package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCampusMapper;
import com.ruoyi.system.domain.SysCampus;
import com.ruoyi.system.service.ISysCampusService;

/**
 * 校区信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
@Service
public class SysCampusServiceImpl implements ISysCampusService 
{
    @Autowired
    private SysCampusMapper sysCampusMapper;

    /**
     * 查询校区信息
     * 
     * @param campusId 校区信息主键
     * @return 校区信息
     */
    @Override
    public SysCampus selectSysCampusByCampusId(Long campusId)
    {
        return sysCampusMapper.selectSysCampusByCampusId(campusId);
    }

    /**
     * 查询校区信息列表
     * 
     * @param sysCampus 校区信息
     * @return 校区信息
     */
    @Override
    public List<SysCampus> selectSysCampusList(SysCampus sysCampus)
    {
        return sysCampusMapper.selectSysCampusList(sysCampus);
    }

    /**
     * 新增校区信息
     * 
     * @param sysCampus 校区信息
     * @return 结果
     */
    @Override
    public int insertSysCampus(SysCampus sysCampus)
    {
        sysCampus.setCreateTime(DateUtils.getNowDate());
        return sysCampusMapper.insertSysCampus(sysCampus);
    }

    /**
     * 修改校区信息
     * 
     * @param sysCampus 校区信息
     * @return 结果
     */
    @Override
    public int updateSysCampus(SysCampus sysCampus)
    {
        sysCampus.setUpdateTime(DateUtils.getNowDate());
        return sysCampusMapper.updateSysCampus(sysCampus);
    }

    /**
     * 批量删除校区信息
     * 
     * @param campusIds 需要删除的校区信息主键
     * @return 结果
     */
    @Override
    public int deleteSysCampusByCampusIds(Long[] campusIds)
    {
        return sysCampusMapper.deleteSysCampusByCampusIds(campusIds);
    }

    /**
     * 删除校区信息信息
     * 
     * @param campusId 校区信息主键
     * @return 结果
     */
    @Override
    public int deleteSysCampusByCampusId(Long campusId)
    {
        return sysCampusMapper.deleteSysCampusByCampusId(campusId);
    }
}
