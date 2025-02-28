package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.SysBuilding;
import com.ruoyi.system.domain.SysCampus;
import com.ruoyi.system.domain.SysRoom;
import com.ruoyi.system.service.ISysBuildingService;
import com.ruoyi.system.service.ISysCampusService;
import com.ruoyi.system.service.ISysRoomService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysWrongdataLog;
import com.ruoyi.system.service.ISysWrongdataLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 实训室登记记录Controller
 *
 * @author ruoyi
 * @date 2024-07-02
 */
@RestController
@RequestMapping("/system/log/wrongdata")
public class SysWrongdataLogController extends BaseController
{
    @Autowired
    private ISysWrongdataLogService sysWrongdataLogService;

    @Autowired
    private ISysRoomService sysRoomService;

    @Autowired
    private ISysCampusService sysCampusService;

    @Autowired
    private ISysBuildingService sysBuildingService;

    /**
     * 查询实训室登记记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:wrongdata:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysWrongdataLog sysWrongdataLog)
    {
        startPage();
        List<SysWrongdataLog> list = sysWrongdataLogService.selectSysWrongdataLogList(sysWrongdataLog);
        return getDataTable(list);
    }

    /**
     * 导出实训室登记记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:wrongdata:export')")
    @Log(title = "实训室登记记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysWrongdataLog sysWrongdataLog)
    {
        List<SysWrongdataLog> list = sysWrongdataLogService.selectSysWrongdataLogList(sysWrongdataLog);
        ExcelUtil<SysWrongdataLog> util = new ExcelUtil<SysWrongdataLog>(SysWrongdataLog.class);
        util.exportExcel(response, list, "实训室登记记录数据");
    }

    /**
     * 获取实训室登记记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:wrongdata:query')")
    @GetMapping(value = "/{wrongdataId}")
    public AjaxResult getInfo(@PathVariable("wrongdataId") Long wrongdataId)
    {
        return success(sysWrongdataLogService.selectSysWrongdataLogByWrongdataId(wrongdataId));
    }

    /**
     * 新增实训室登记记录
     * @Anonymous注解 任何人都可以访问
     */
//    @PreAuthorize("@ss.hasPermi('system:log:add')")
//    @Log(title = "实训室登记记录", businessType = BusinessType.INSERT)
    @Anonymous
    @PostMapping
    public AjaxResult add(@RequestBody SysWrongdataLog sysWrongdataLog)
    {
        return toAjax(sysWrongdataLogService.insertSysWrongdataLog(sysWrongdataLog));
    }

    /**
     * 问卷页面加载数据
     * @return
     */
    @Anonymous
    @GetMapping(value = "/init")
    public AjaxResult init()
    {
        AjaxResult ajax = AjaxResult.success();
        //获取校区列表
        ajax.put("campusList", sysCampusService.selectSysCampusList(new SysCampus()));
        ajax.put("buildingList", sysBuildingService.selectSysBuildingList(new SysBuilding()));
        ajax.put("roomList", sysRoomService.selectSysRoomList(new SysRoom()));
        return ajax;
    }

    /**
     * 修改实训室登记记录
     */
    @PreAuthorize("@ss.hasPermi('system:wrongdata:edit')")
    @Log(title = "实训室登记记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysWrongdataLog sysWrongdataLog)
    {
        return toAjax(sysWrongdataLogService.updateSysWrongdataLog(sysWrongdataLog));
    }

    /**
     * 修改实训室登记记录，处理的状态
     */
//    @PreAuthorize("@ss.hasPermi('system:wrongdata:editdone')")
//    @Log(title = "实训室登记记录", businessType = BusinessType.UPDATE)
//    @PutMapping("/editdone")
//    public AjaxResult editdone(@RequestBody SysWrongdataLog sysWrongdataLog)
//    {
//        return toAjax(sysWrongdataLogService.editdone(sysWrongdataLog));
//    }

    /**
     * 删除实训室登记记录
     */
    @PreAuthorize("@ss.hasPermi('system:wrongdata:remove')")
    @Log(title = "实训室登记记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{wrongdataIds}")
    public AjaxResult remove(@PathVariable Long[] wrongdataIds)
    {
        return toAjax(sysWrongdataLogService.deleteSysWrongdataLogByWrongdataIds(wrongdataIds));
    }
}
