package com.ruoyi.system.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysBuilding;
import com.ruoyi.system.domain.SysCampus;
import com.ruoyi.system.domain.SysRoom;
import com.ruoyi.system.mapper.SysBuildingMapper;
import com.ruoyi.system.mapper.SysCampusMapper;
import com.ruoyi.system.mapper.SysRoomMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysWrongdataLogMapper;
import com.ruoyi.system.domain.SysWrongdataLog;
import com.ruoyi.system.service.ISysWrongdataLogService;

/**
 * 实训室登记记录Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-02
 */
@Service
public class SysWrongdataLogServiceImpl implements ISysWrongdataLogService
{

    private static final Logger log = LoggerFactory.getLogger(SysWrongdataLogServiceImpl.class);

    @Autowired
    private SysWrongdataLogMapper sysWrongdataLogMapper;

    @Autowired
    private SysCampusMapper sysCampusMapper;

    @Autowired
    private SysBuildingMapper sysBuildingMapper;

    @Autowired
    private SysRoomMapper sysRoomMapper;

    /**
     * 查询实训室登记记录
     *
     * @param wrongdataId 实训室登记记录主键
     * @return 实训室登记记录
     */
    @Override
    public SysWrongdataLog selectSysWrongdataLogByWrongdataId(Long wrongdataId)
    {
        return sysWrongdataLogMapper.selectSysWrongdataLogByWrongdataId(wrongdataId);
    }

    /**
     * 查询实训室登记记录列表
     *
     * @param sysWrongdataLog 实训室登记记录
     * @return 实训室登记记录
     */
    @Override
    public List<SysWrongdataLog> selectSysWrongdataLogList(SysWrongdataLog sysWrongdataLog)
    {
        return sysWrongdataLogMapper.selectSysWrongdataLogList(sysWrongdataLog);
    }

    /**
     * 新增实训室登记记录
     *
     * @param sysWrongdataLog 实训室登记记录
     * @return 结果
     */
    @Override
    public int insertSysWrongdataLog(SysWrongdataLog sysWrongdataLog)
    {
        //拼接实训室详细地址
        SysCampus sysCampus = sysCampusMapper.selectSysCampusByCampusId(sysWrongdataLog.getCampusId());
        SysBuilding sysBuilding = sysBuildingMapper.selectSysBuildingByBuildingId(sysWrongdataLog.getBuildingId());
//        SysRoom sysRoom = sysRoomMapper.selectSysRoomByRoomId(sysWrongdataLog.getRoomId());
        if (sysCampus != null && sysBuilding != null){
            String address = sysCampus.getCampusName() + "-" + sysBuilding.getBuildingName() + "-" + sysWrongdataLog.getRoomName();
            sysWrongdataLog.setAddress(address);
        }else {
            log.info("凭借实训室详细地址有点问题 campusId={} buildingId={} roomId={}", sysWrongdataLog.getCampusId(),
                    sysWrongdataLog.getBuildingId(), sysWrongdataLog.getRoomName());
        }
        sysWrongdataLog.setSchoolWeek(DateUtils.getSchoolWeekStr(sysWrongdataLog.getDate()));
        sysWrongdataLog.setWeek(DateUtils.getWeekStr(sysWrongdataLog.getDate()));

        //判断备注是否是“无”字.如果是，状态改成0。如果不是，状态改成1
        if ("无".equals(sysWrongdataLog.getReason())){
            sysWrongdataLog.setDone(0);
        }else {
            sysWrongdataLog.setDone(1);
        }

        return sysWrongdataLogMapper.insertSysWrongdataLog(sysWrongdataLog);
    }

    /**
     * 修改实训室登记记录
     *
     * @param sysWrongdataLog 实训室登记记录
     * @return 结果
     */
    @Override
    public int updateSysWrongdataLog(SysWrongdataLog sysWrongdataLog)
    {
        return sysWrongdataLogMapper.updateSysWrongdataLog(sysWrongdataLog);
    }

    /**
     * 批量删除实训室登记记录
     *
     * @param wrongdataIds 需要删除的实训室登记记录主键
     * @return 结果
     */
    @Override
    public int deleteSysWrongdataLogByWrongdataIds(Long[] wrongdataIds)
    {
        return sysWrongdataLogMapper.deleteSysWrongdataLogByWrongdataIds(wrongdataIds);
    }

    /**
     * 删除实训室登记记录信息
     *
     * @param wrongdataId 实训室登记记录主键
     * @return 结果
     */
    @Override
    public int deleteSysWrongdataLogByWrongdataId(Long wrongdataId)
    {
        return sysWrongdataLogMapper.deleteSysWrongdataLogByWrongdataId(wrongdataId);
    }


}
