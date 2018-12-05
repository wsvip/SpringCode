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

    @Override
    public Boolean checkUsername(String username) {
        String uname = userDao.checkUsername(username);
        if(null==uname){
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkEmail(String email) {
      String uemail=  userDao.checkEmail(email);
      if(null==uemail){
          return true;
      }
        return false;
    }

    @Override
    public Boolean checkPhone(String tellphone) {
        String phone=userDao.checkPhone(tellphone);
        if(null==phone){
            return true;
        }
        return false;
    }
}
