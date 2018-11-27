package com.ws.service;

import com.ws.bean.SysUser;


public interface UserService {
    SysUser findByUsername(String username);

    SysUser save(SysUser sysUser);
}
