package com.ws.controller;

import com.ws.bean.SysUser;
import com.ws.service.UserService;
import com.ws.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String goToRegister() {
        return "/register";
    }

    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    @ResponseBody
    public Boolean helloHtml(SysUser formData) {
        String uuid = UuidUtils.getUuid();
        formData.setId(uuid);
        SysUser save = userService.save(formData);
        System.err.println(save);
        return true;
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
