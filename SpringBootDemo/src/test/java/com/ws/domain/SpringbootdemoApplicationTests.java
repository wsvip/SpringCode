package com.ws.domain;

import com.ws.bean.Sys_User;
import com.ws.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
        Sys_User sysUser = new Sys_User();
        sysUser.setUsername("zs");
        sysUser.setPassword("124");
       // sysUser.setEmail("120171785@qq.com");
        sysUser.setNickname("张三");
        Sys_User count = userDao.save(sysUser);
        //System.err.println(count.getEmail());
    }

}
