package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间信息对象 sys_room
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
public class SysRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房间ID */
    private Long roomId;

    /** 房间名称 */
    @Excel(name = "房间名称")
    private String roomName;

    /** 校区id */
    @Excel(name = "校区id")
    private Long campusId;

    /** 建筑物id */
    @Excel(name = "建筑物id")
    private Long buildingId;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 校区对象 **/
    @Excels({
            @Excel(name = "校区名称", targetAttr = "campusName", type = Excel.Type.EXPORT)
    })
    private SysCampus sysCampus;

    /** 建筑物对象 **/
    @Excels({
            @Excel(name = "建筑物名称", targetAttr = "buildingName", type = Excel.Type.EXPORT)
    })
    private SysBuilding sysBuilding;

    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setRoomName(String roomName) 
    {
        this.roomName = roomName;
    }

    public String getRoomName() 
    {
        return roomName;
    }
    public void setCampusId(Long campusId) 
    {
        this.campusId = campusId;
    }

    public Long getCampusId() 
    {
        return campusId;
    }
    public void setBuildingId(Long buildingId) 
    {
        this.buildingId = buildingId;
    }

    public Long getBuildingId() 
    {
        return buildingId;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roomId", getRoomId())
            .append("roomName", getRoomName())
            .append("campusId", getCampusId())
            .append("buildingId", getBuildingId())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }

    public SysCampus getSysCampus() {
        return sysCampus;
    }

    public void setSysCampus(SysCampus sysCampus) {
        this.sysCampus = sysCampus;
    }

    public SysBuilding getSysBuilding() {
        return sysBuilding;
    }

    public void setSysBuilding(SysBuilding sysBuilding) {
        this.sysBuilding = sysBuilding;
    }
}
