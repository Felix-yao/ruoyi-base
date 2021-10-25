package com.ruoyi.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
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
import com.ruoyi.system.domain.TTest;
import com.ruoyi.system.service.ITTestService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * testController
 *
 * @author ruoyi
 * @date 2021-10-25
 */
@RestController
@RequestMapping("/system/test")
public class TTestController extends BaseController
{
    @Autowired
    private ITTestService tTestService;

    /**
     * 查询test列表
     */
    @PreAuthorize("@ss.hasPermi('system:test:list')")
    @GetMapping("/list")
    public TableDataInfo list(TTest tTest)
    {
        startPage();

        QueryWrapper queryWrapper = new QueryWrapper<>();

        List<TTest> list = tTestService.list(queryWrapper);
        return getDataTable(list);
    }

    /**
     * 导出test列表
     */
    @PreAuthorize("@ss.hasPermi('system:test:export')")
    @Log(title = "test", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TTest tTest)
    {
        List<TTest> list = tTestService.list(new QueryWrapper<>(tTest));
        ExcelUtil<TTest> util = new ExcelUtil<TTest>(TTest.class);
        return util.exportExcel(list, "test数据");
    }

    /**
     * 获取test详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:test:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tTestService.getById(id));
    }

    /**
     * 新增test
     */
    @PreAuthorize("@ss.hasPermi('system:test:add')")
    @Log(title = "test", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TTest tTest)
    {
        return toAjax(tTestService.save(tTest));
    }

    /**
     * 修改test
     */
    @PreAuthorize("@ss.hasPermi('system:test:edit')")
    @Log(title = "test", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TTest tTest)
    {
        return toAjax(tTestService.updateById(tTest));
    }

    /**
     * 删除test
     */
    @PreAuthorize("@ss.hasPermi('system:test:remove')")
    @Log(title = "test", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable List ids)
    {
        return toAjax(tTestService.removeByIds(ids));
    }
}
