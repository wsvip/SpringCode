package com.ws.dao;

import com.ws.bean.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserDao extends JpaRepository<SysUser, String> {
    SysUser findByUsername(String username);
    SysUser save(SysUser sysUser);
}
