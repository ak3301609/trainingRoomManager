package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysBuilding;
import com.ruoyi.system.domain.SysCampus;
import com.ruoyi.system.service.ISysBuildingService;
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
import com.ruoyi.system.domain.SysRoom;
import com.ruoyi.system.service.ISysRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房间信息Controller
 * 
 * @author ruoyi
 * @date 2024-07-02
 */
@RestController
@RequestMapping("/system/room")
public class SysRoomController extends BaseController
{
    @Autowired
    private ISysRoomService sysRoomService;

    @Autowired
    private ISysCampusService sysCampusService;

    @Autowired
    private ISysBuildingService sysBuildingService;

    /**
     * 查询房间信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:room:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRoom sysRoom)
    {
        startPage();
        List<SysRoom> list = sysRoomService.selectSysRoomList(sysRoom);
        return getDataTable(list);
    }

    /**
     * 导出房间信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:room:export')")
    @Log(title = "房间信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRoom sysRoom)
    {
        List<SysRoom> list = sysRoomService.selectSysRoomList(sysRoom);
        ExcelUtil<SysRoom> util = new ExcelUtil<SysRoom>(SysRoom.class);
        util.exportExcel(response, list, "房间信息数据");
    }

    /**
     * 获取房间信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:room:query')")
    @GetMapping(value = {"/", "/{roomId}"})
    public AjaxResult getInfo(@PathVariable(value="roomId", required = false) Long roomId)
    {
        AjaxResult ajax = AjaxResult.success();
        //获取校区列表
        ajax.put("campusList", sysCampusService.selectSysCampusList(new SysCampus()));
        ajax.put("buildingList", sysBuildingService.selectSysBuildingList(new SysBuilding()));
        if (StringUtils.isNotNull(roomId))
        {
            SysRoom sysRoom = sysRoomService.selectSysRoomByRoomId(roomId);
            ajax.put(AjaxResult.DATA_TAG, sysRoom);
        }
        return ajax;
    }

    /**
     * 新增房间信息
     */
    @PreAuthorize("@ss.hasPermi('system:room:add')")
    @Log(title = "房间信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRoom sysRoom)
    {
        return toAjax(sysRoomService.insertSysRoom(sysRoom));
    }

    /**
     * 修改房间信息
     */
    @PreAuthorize("@ss.hasPermi('system:room:edit')")
    @Log(title = "房间信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRoom sysRoom)
    {
        return toAjax(sysRoomService.updateSysRoom(sysRoom));
    }

    /**
     * 删除房间信息
     */
    @PreAuthorize("@ss.hasPermi('system:room:remove')")
    @Log(title = "房间信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roomIds}")
    public AjaxResult remove(@PathVariable Long[] roomIds)
    {
        return toAjax(sysRoomService.deleteSysRoomByRoomIds(roomIds));
    }
}
