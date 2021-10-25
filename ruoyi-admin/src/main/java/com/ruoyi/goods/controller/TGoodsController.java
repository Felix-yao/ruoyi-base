package com.ruoyi.goods.controller;

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
import com.ruoyi.goods.domain.TGoods;
import com.ruoyi.goods.service.ITGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 货物Controller
 *
 * @author ruoyi
 * @date 2021-10-22
 */
@RestController
@RequestMapping("/goods/goods")
public class TGoodsController extends BaseController
{
    @Autowired
    private ITGoodsService tGoodsService;

    /**
     * 查询货物列表
     */
    @PreAuthorize("@ss.hasPermi('goods:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(TGoods tGoods)
    {
        startPage();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        if (null!=tGoods.getCode())
            queryWrapper.like("code", tGoods.getCode());

        List<TGoods> list = tGoodsService.list(queryWrapper);
        return getDataTable(list);
    }

    /**
     * 导出货物列表
     */
    @PreAuthorize("@ss.hasPermi('goods:goods:export')")
    @Log(title = "货物", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TGoods tGoods)
    {
        List<TGoods> list = tGoodsService.list(new QueryWrapper<>(tGoods));
        ExcelUtil<TGoods> util = new ExcelUtil<TGoods>(TGoods.class);
        return util.exportExcel(list, "货物数据");
    }

    /**
     * 获取货物详细信息
     */
    @PreAuthorize("@ss.hasPermi('goods:goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tGoodsService.getById(id));
    }

    /**
     * 新增货物
     */
    @PreAuthorize("@ss.hasPermi('goods:goods:add')")
    @Log(title = "货物", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TGoods tGoods)
    {
        return toAjax(tGoodsService.save(tGoods));
    }

    /**
     * 修改货物
     */
    @PreAuthorize("@ss.hasPermi('goods:goods:edit')")
    @Log(title = "货物", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TGoods tGoods)
    {
        return toAjax(tGoodsService.updateById(tGoods));
    }

    /**
     * 删除货物
     */
    @PreAuthorize("@ss.hasPermi('goods:goods:remove')")
    @Log(title = "货物", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long ids)
    {
        return toAjax(tGoodsService.removeById(ids));
    }
}
