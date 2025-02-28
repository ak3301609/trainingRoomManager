package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实训室登记记录对象 sys_wrongdata_log
 *
 * @author ruoyi
 * @date 2024-07-02
 */
public class SysWrongdataLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 登记信息ID */
    private Long wrongdataId;

    /** 教工号 */
    @Excel(name = "教工号")
    private String techerId;

    /** 教职工名称 */
    @Excel(name = "教职工名称")
    private String techerName;

    /** 实训室详细地址 */
    @Excel(name = "实训室详细地址")
    private String address;

    /** 备注 */
    @Excel(name = "备注")
    private String reason;

    /** 登记时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "登记时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    @Excel(name = "教学周")
    private String schoolWeek;

    @Excel(name = "星期")
    private String week;

    /** $column.columnComment */
    private Integer done;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String className;

    /** 课节 */
    @Excel(name = "课节")
    private String kejie;

    /** 校区id */
//    @Excel(name = "校区id")
    private Long campusId;

    /** 楼栋id */
//    @Excel(name = "楼栋id")
    private Long buildingId;

    /** 实训室id */
//    @Excel(name = "实训室id")
    private Long roomId;

    /**
     * 实训室名称
     */
    private String roomName;

    /** 课程 */
    @Excel(name = "课程")
    private String course;

    public void setWrongdataId(Long wrongdataId)
    {
        this.wrongdataId = wrongdataId;
    }

    public Long getWrongdataId()
    {
        return wrongdataId;
    }
    public void setTecherId(String techerId)
    {
        this.techerId = techerId;
    }

    public String getTecherId()
    {
        return techerId;
    }
    public void setTecherName(String techerName)
    {
        this.techerName = techerName;
    }

    public String getTecherName()
    {
        return techerName;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getReason()
    {
        return reason;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getClassName()
    {
        return className;
    }
    public void setKejie(String kejie)
    {
        this.kejie = kejie;
    }

    public String getKejie()
    {
        return kejie;
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
    public void setRoomId(Long roomId)
    {
        this.roomId = roomId;
    }

    public Long getRoomId()
    {
        return roomId;
    }
    public void setCourse(String course)
    {
        this.course = course;
    }

    public String getCourse()
    {
        return course;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wrongdataId", getWrongdataId())
            .append("techerId", getTecherId())
            .append("techerName", getTecherName())
            .append("address", getAddress())
            .append("reason", getReason())
            .append("date", getDate())
            .append("done", getDone())
            .append("className", getClassName())
            .append("kejie", getKejie())
            .append("campusId", getCampusId())
            .append("buildingId", getBuildingId())
            .append("roomId", getRoomId())
            .append("course", getCourse())
            .toString();
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSchoolWeek() {
        return schoolWeek;
    }

    public void setSchoolWeek(String schoolWeek) {
        this.schoolWeek = schoolWeek;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
