package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysCampus;
import com.ruoyi.system.service.ISysCampusService;
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
import com.ruoyi.system.domain.SysBuilding;
import com.ruoyi.system.service.ISysBuildingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 建筑物信息Controller
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
@RestController
@RequestMapping("/system/building")
public class SysBuildingController extends BaseController
{
    @Autowired
    private ISysBuildingService sysBuildingService;

    @Autowired
    private ISysCampusService sysCampusService;

    /**
     * 查询建筑物信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:building:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysBuilding sysBuilding)
    {
        startPage();
        List<SysBuilding> list = sysBuildingService.selectSysBuildingList(sysBuilding);
        return getDataTable(list);
    }

    /**
     * 导出建筑物信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:building:export')")
    @Log(title = "建筑物信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysBuilding sysBuilding)
    {
        List<SysBuilding> list = sysBuildingService.selectSysBuildingList(sysBuilding);
        ExcelUtil<SysBuilding> util = new ExcelUtil<SysBuilding>(SysBuilding.class);
        util.exportExcel(response, list, "建筑物信息数据");
    }

    /**
     * 获取建筑物信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:building:query')")
    @GetMapping(value = {"/", "/{buildingId}"})
    public AjaxResult getInfo(@PathVariable(value = "buildingId", required = false) Long buildingId)
    {
        AjaxResult ajax = AjaxResult.success();
        //获取校区列表
        ajax.put("campusList", sysCampusService.selectSysCampusList(new SysCampus()));
        if (StringUtils.isNotNull(buildingId))
        {
            SysBuilding sysBuilding = sysBuildingService.selectSysBuildingByBuildingId(buildingId);
            ajax.put(AjaxResult.DATA_TAG, sysBuilding);
        }
        return ajax;
    }

    /**
     * 新增建筑物信息
     */
    @PreAuthorize("@ss.hasPermi('system:building:add')")
    @Log(title = "建筑物信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysBuilding sysBuilding)
    {
        return toAjax(sysBuildingService.insertSysBuilding(sysBuilding));
    }

    /**
     * 修改建筑物信息
     */
    @PreAuthorize("@ss.hasPermi('system:building:edit')")
    @Log(title = "建筑物信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysBuilding sysBuilding)
    {
        return toAjax(sysBuildingService.updateSysBuilding(sysBuilding));
    }

    /**
     * 删除建筑物信息
     */
    @PreAuthorize("@ss.hasPermi('system:building:remove')")
    @Log(title = "建筑物信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{buildingIds}")
    public AjaxResult remove(@PathVariable Long[] buildingIds)
    {
        return toAjax(sysBuildingService.deleteSysBuildingByBuildingIds(buildingIds));
    }
}
