package com.ruoyi.framework.config.Handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ruoyi.framework.security.util.UserUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName : MyMetaObjectHandler
 * @Description :
 * @Author : felix
 * @Date: 2021-10-25 14:05
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(),metaObject);
        this.setFieldValByName("updateTime", new Date(),metaObject);
        this.setFieldValByName("createBy", UserUtil.userInfo().getUserId().toString(),metaObject);
        this.setFieldValByName("updateBy", UserUtil.userInfo().getUserId().toString(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(),metaObject);
        this.setFieldValByName("updateBy", UserUtil.userInfo().getUserId().toString(),metaObject);
    }
}
