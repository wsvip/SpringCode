package com.ws.controller;

import com.ws.bean.SysUser;
import com.ws.service.UserService;
import com.ws.utils.MD5Utils;
import com.ws.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String goToRegister() {
        return "/register";
    }
    /**
     * @Author: WS
     * @Date: 2018/11/30 10:29
     * @Params: [formData]
     * @return: 成功 true，失败false
     * @Description: 用户注册
     *
     */
    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    @ResponseBody
    public Boolean helloHtml(SysUser formData) {
        System.err.println(formData);
        try {
            //生成用户的uuid
            String uuid = UuidUtils.getUuid();
            //加密用户密码
            String pwd = formData.getPassword();
            for (int i = 0; i < 5; i++) {
                pwd=MD5Utils.encode(pwd);
            }
            //将uuid和加密后的密码重新添加到用户信息中
            formData.setId(uuid);
            formData.setPassword(pwd);
            SysUser save = userService.save(formData);
            System.err.println(save);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(path = "/saveUser", method = RequestMethod.POST)
    public String saveUser(String username, String password, String email, String nickname) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        //sysUser.setEmail(email);
        sysUser.setNickname(nickname);
        userService.save(sysUser);
        return "/hello";
    }

    @RequestMapping(path = "/findUserByUsername", method = RequestMethod.POST)
    public String findUserByUsername(String username, Map<String, Object> map) {
        SysUser sysUser = userService.findByUsername(username);
        map.put("userkey", sysUser);
        return "/hello";
    }

}
