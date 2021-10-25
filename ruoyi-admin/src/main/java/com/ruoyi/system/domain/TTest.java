package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.ruoyi.common.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * test对象 t_test
 *
 * @author ruoyi
 * @date 2021-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TTest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Long id;


    /** 姓名 */
    @Excel(name = "姓名")
    @TableField(value = "name")

    private String name;




}
