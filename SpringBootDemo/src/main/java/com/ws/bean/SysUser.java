package com.ws.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SYSUSER")
public class SysUser implements Serializable {
    @Id
   // @GenericGenerator(name = "userId", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
   // @GeneratedValue(generator = "userId")
    private String id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String password;
    /*@Column(nullable = true,unique = true)
    private String email;*/
    @Column(nullable = true, unique = true)
    private String nickname;

    @Column(nullable = true, unique = true)
    public String email;
    @Column(nullable = true, unique = true)
    public String tellphone;
    @Column(nullable = true, unique = true)
    public String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTellphone() {
        return tellphone;
    }

    public void setTellphone(String tellphone) {
        this.tellphone = tellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", tellphone='" + tellphone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
