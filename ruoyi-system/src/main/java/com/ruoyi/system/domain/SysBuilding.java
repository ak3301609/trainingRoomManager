package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 建筑物信息对象 sys_building
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
public class SysBuilding extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 建筑物ID */
    private Long buildingId;

    /** 建筑物名称 */
    @Excel(name = "建筑物名称")
    private String buildingName;

    /** 校区id */
    @Excel(name = "校区id")
    private Long campusId;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 校区对象 **/
    @Excels({
            @Excel(name = "校区名称", targetAttr = "campusName", type = Excel.Type.EXPORT)
    })
    private SysCampus sysCampus;

    public void setBuildingId(Long buildingId) 
    {
        this.buildingId = buildingId;
    }

    public Long getBuildingId() 
    {
        return buildingId;
    }
    public void setBuildingName(String buildingName) 
    {
        this.buildingName = buildingName;
    }

    public String getBuildingName() 
    {
        return buildingName;
    }
    public void setCampusId(Long campusId) 
    {
        this.campusId = campusId;
    }

    public Long getCampusId() 
    {
        return campusId;
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
            .append("buildingId", getBuildingId())
            .append("buildingName", getBuildingName())
            .append("campusId", getCampusId())
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
}
