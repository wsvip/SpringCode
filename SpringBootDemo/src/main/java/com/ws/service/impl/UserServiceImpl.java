package com.ws.service.impl;

import com.ws.bean.SysUser;
import com.ws.dao.UserDao;
import com.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public SysUser save(SysUser sysUser) {
        SysUser save = userDao.save(sysUser);
        return save;
    }
}
