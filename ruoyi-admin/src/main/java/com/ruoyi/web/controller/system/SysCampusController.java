package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.SysCampus;
import com.ruoyi.system.service.ISysCampusService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 校区信息Controller
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
@RestController
@RequestMapping("/system/campus")
public class SysCampusController extends BaseController
{
    @Autowired
    private ISysCampusService sysCampusService;

    /**
     * 查询校区信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:campus:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCampus sysCampus)
    {
        startPage();
        List<SysCampus> list = sysCampusService.selectSysCampusList(sysCampus);
        return getDataTable(list);
    }

    /**
     * 导出校区信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:campus:export')")
    @Log(title = "校区信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysCampus sysCampus)
    {
        List<SysCampus> list = sysCampusService.selectSysCampusList(sysCampus);
        ExcelUtil<SysCampus> util = new ExcelUtil<SysCampus>(SysCampus.class);
        util.exportExcel(response, list, "校区信息数据");
    }

    /**
     * 获取校区信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:campus:query')")
    @GetMapping(value = "/{campusId}")
    public AjaxResult getInfo(@PathVariable("campusId") Long campusId)
    {
        return success(sysCampusService.selectSysCampusByCampusId(campusId));
    }

    /**
     * 新增校区信息
     */
    @PreAuthorize("@ss.hasPermi('system:campus:add')")
    @Log(title = "校区信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCampus sysCampus)
    {
        return toAjax(sysCampusService.insertSysCampus(sysCampus));
    }

    /**
     * 修改校区信息
     */
    @PreAuthorize("@ss.hasPermi('system:campus:edit')")
    @Log(title = "校区信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCampus sysCampus)
    {
        return toAjax(sysCampusService.updateSysCampus(sysCampus));
    }

    /**
     * 删除校区信息
     */
    @PreAuthorize("@ss.hasPermi('system:campus:remove')")
    @Log(title = "校区信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{campusIds}")
    public AjaxResult remove(@PathVariable Long[] campusIds)
    {
        return toAjax(sysCampusService.deleteSysCampusByCampusIds(campusIds));
    }
}
