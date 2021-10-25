package com.ruoyi.framework.security.util;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * @ClassName : UserUtil
 * @Description : 用户工具类
 * @Author : felix
 * @Date: 2021-10-25 14:12
 */

@Component
public class UserUtil {

    // 获取用户身份信息
    public static SysUser userInfo(){
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();
        return user;
    }

}
