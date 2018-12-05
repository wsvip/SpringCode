package com.ws.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.ws.bean.SysUser;
import com.ws.service.UserService;
import com.ws.utils.MD5Utils;
import com.ws.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
                pwd = MD5Utils.encode(pwd);
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

    /**
     * @Author: WS
     * @Date: 2018/12/5 12:24
     * @Params: username
     * @return: 返回一个json数据，格式为{"valid":false}
     * @Description: 校验用户名是否存在，存在返回false，不存在返回true
     * {"valid":false} //表示不合法，验证不通过
     * {"valid":true} //表示合法，验证通过
     */
    @ResponseBody
    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    public Map<String, Boolean> checkUsername(String username) {
        Boolean result = userService.checkUsername(username);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("valid", result);
        return map;
    }

    /**
     * @Author: WS
     * @Date: 2018/12/5 19:01
     * @Params: email
     * @return: 返回一个json数据，格式为{"valid":false}
     * @Description: 校验邮箱是否存在，存在返回false，不存在返回true
     * {"valid":false} //表示不合法，验证不通过
     * {"valid":true} //表示合法，验证通过
     */
    @ResponseBody
    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public Map<String, Boolean> checkEmail(String email) {
        Boolean result= userService.checkEmail(email);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("valid",result);
        return map;
    }
    /**
     * @Author: WS
     * @Date: 2018/12/5 19:13
     * @Params: tellphone
     * @return:  返回一个json数据，格式为{"valid":false}
     * @Description: 校验手机号是否存在，存在返回false，不存在返回true
     *  {"valid":false} //表示不合法，验证不通过
     *  {"valid":true} //表示合法，验证通过
     */
    @ResponseBody
    @RequestMapping(value = "checkPhone",method = RequestMethod.POST)
    public Map<String ,Boolean >checkPhone(String tellphone){
        Boolean result=userService.checkPhone(tellphone);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("valid",result);
        return map;
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
