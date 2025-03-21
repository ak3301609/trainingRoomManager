package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysWrongdataLog;

/**
 * 实训室登记记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
public interface SysWrongdataLogMapper 
{
    /**
     * 查询实训室登记记录
     * 
     * @param wrongdataId 实训室登记记录主键
     * @return 实训室登记记录
     */
    public SysWrongdataLog selectSysWrongdataLogByWrongdataId(Long wrongdataId);

    /**
     * 查询实训室登记记录列表
     * 
     * @param sysWrongdataLog 实训室登记记录
     * @return 实训室登记记录集合
     */
    public List<SysWrongdataLog> selectSysWrongdataLogList(SysWrongdataLog sysWrongdataLog);

    /**
     * 新增实训室登记记录
     * 
     * @param sysWrongdataLog 实训室登记记录
     * @return 结果
     */
    public int insertSysWrongdataLog(SysWrongdataLog sysWrongdataLog);

    /**
     * 修改实训室登记记录
     * 
     * @param sysWrongdataLog 实训室登记记录
     * @return 结果
     */
    public int updateSysWrongdataLog(SysWrongdataLog sysWrongdataLog);

    /**
     * 删除实训室登记记录
     * 
     * @param wrongdataId 实训室登记记录主键
     * @return 结果
     */
    public int deleteSysWrongdataLogByWrongdataId(Long wrongdataId);

    /**
     * 批量删除实训室登记记录
     * 
     * @param wrongdataIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysWrongdataLogByWrongdataIds(Long[] wrongdataIds);
}
