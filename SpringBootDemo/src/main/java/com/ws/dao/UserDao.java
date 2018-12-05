package com.ws.dao;

import com.ws.bean.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<SysUser, String> {
    SysUser findByUsername(String username);

    SysUser save(SysUser sysUser);

    @Query(value = "select username from SysUser where  username=?1")
    String checkUsername(String username);
    @Query(value = "select email from SysUser where email=?1")
    String checkEmail(String email);
    @Query(value="select tellphone from SysUser where tellphone =?1")
    String checkPhone(String tellphone);
}
