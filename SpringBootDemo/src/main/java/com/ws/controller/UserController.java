package com.ws.controller;


import com.ws.bean.Sys_User;
import com.ws.service.UserService;
import com.ws.common.utils.MD5Utils;
import com.ws.common.utils.UuidUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @Author:  WS-
     * @param username
     * @param password
     * @param email
     * @param nickname
     * @return:
     * @Date:    2019/4/22  10:52
     * @Description:
     */
    @RequestMapping(path = "/saveUser", method = RequestMethod.POST)
    public String saveUser(String username, String password, String email, String nickname) {
        Sys_User sysUser = new Sys_User();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        //sysUser.setEmail(email);
        sysUser.setNickname(nickname);
        userService.save(sysUser);
        return "/hello";
    }

    @RequestMapping(path = "/findUserByUsername", method = RequestMethod.POST)
    public String findUserByUsername(String username, Map<String, Object> map) {
        Sys_User sysUser = userService.findByUsername(username);
        map.put("userkey", sysUser);
        return "/hello";
    }

}
