package com.ruoyi.goods.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.ruoyi.common.annotation.Excel;

/**
 * 货物对象 t_goods
 *
 * @author ruoyi
 * @date 2021-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "t_goods")//指定表名
public class TGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    @TableField("name")
    private String name;

    /** 编号 */
    @Excel(name = "编号")
    @TableField("code")
    private String code;

    /** 品牌 */
    @Excel(name = "品牌")
    @TableField("brand")
    private String brand;

    /** 型号 */
    @Excel(name = "型号")
    @TableField("model")
    private String model;

    /** 删除标志（0代表存在 2代表删除） */
    @TableField("del_flag")
    private String delFlag;


}
