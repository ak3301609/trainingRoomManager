package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 校区信息对象 sys_campus
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
public class SysCampus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 校区ID */
    private Long campusId;

    /** 校区名称 */
    @Excel(name = "校区名称")
    private String campusName;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setCampusId(Long campusId) 
    {
        this.campusId = campusId;
    }

    public Long getCampusId() 
    {
        return campusId;
    }
    public void setCampusName(String campusName) 
    {
        this.campusName = campusName;
    }

    public String getCampusName() 
    {
        return campusName;
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
            .append("campusId", getCampusId())
            .append("campusName", getCampusName())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
