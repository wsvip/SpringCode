package com.ws.dao;

import com.ws.bean.Sys_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserDao extends JpaRepository<Sys_User, String> {
    Sys_User findByUsername(String username);

    Sys_User save(Sys_User sysUser);

    @Query(value = "select username from Sys_User where  username=?1")
    String checkUsername(String username);
    @Query(value = "select email from Sys_User where email=?1")
    String checkEmail(String email);
    @Query(value="select tellphone from Sys_User where tellphone =?1")
    String checkPhone(String tellphone);
    @Modifying
    @Transactional
    @Query("update Sys_User u set u.loginIp=?1,u.loginCount=?2,u.loginAt=?3 where id=?4")
    void updateUserWhenLogin(String loginIp, int loginCount, int loginAt, String id);
}
