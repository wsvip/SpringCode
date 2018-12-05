package com.ws.service;

import com.ws.bean.SysUser;


public interface UserService {
    SysUser findByUsername(String username);

    SysUser save(SysUser sysUser);
    /**
     * @Author: WS
     * @Date: 2018/12/5 19:05
     * @Params: username
     * @return: boolean
     * @Description: 校验用户名是否存在，存在返回true，不存在返回false
     *
     */
    Boolean checkUsername(String username);
    /**
     * @Author: WS
     * @Date: 2018/12/5 19:05
     * @Params: email
     * @return: boolean
     * @Description: 校验邮箱是否存在，存在返回false，不存在返回true
     *
     */
    Boolean checkEmail(String email);

     /**
     * @Author: WS
     * @Date: 2018/12/5 19:13
     * @Params: tellphone
     * @return:  boolean
     * @Description: 校验手机号是否存在，存在返回false，不存在返回true
     */
    Boolean checkPhone(String tellphone);
}
