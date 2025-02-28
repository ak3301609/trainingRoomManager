package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysCampus;

/**
 * 校区信息Service接口
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
public interface ISysCampusService 
{
    /**
     * 查询校区信息
     * 
     * @param campusId 校区信息主键
     * @return 校区信息
     */
    public SysCampus selectSysCampusByCampusId(Long campusId);

    /**
     * 查询校区信息列表
     * 
     * @param sysCampus 校区信息
     * @return 校区信息集合
     */
    public List<SysCampus> selectSysCampusList(SysCampus sysCampus);

    /**
     * 新增校区信息
     * 
     * @param sysCampus 校区信息
     * @return 结果
     */
    public int insertSysCampus(SysCampus sysCampus);

    /**
     * 修改校区信息
     * 
     * @param sysCampus 校区信息
     * @return 结果
     */
    public int updateSysCampus(SysCampus sysCampus);

    /**
     * 批量删除校区信息
     * 
     * @param campusIds 需要删除的校区信息主键集合
     * @return 结果
     */
    public int deleteSysCampusByCampusIds(Long[] campusIds);

    /**
     * 删除校区信息信息
     * 
     * @param campusId 校区信息主键
     * @return 结果
     */
    public int deleteSysCampusByCampusId(Long campusId);
}
