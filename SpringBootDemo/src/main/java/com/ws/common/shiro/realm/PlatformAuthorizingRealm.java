package com.ws.common.shiro.realm;

import com.ws.bean.Sys_User;
import com.ws.common.shiro.token.PlatformToken;
import com.ws.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class PlatformAuthorizingRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token.getClass().isAssignableFrom(PlatformToken.class)) {
            PlatformToken authToken = (PlatformToken) token;
            String username = authToken.getUsername();
            //String captcha = authToken.getCaptcha();
            //获取该用户的session
            Session session = SecurityUtils.getSubject().getSession();
            Sys_User user = userService.findByUsername(username);
            session.setAttribute("username", username);
            session.setAttribute("nickname", user.getNickname());
            session.setAttribute("loginerrorCount", 0);
            session.setAttribute("user", user);
            session.setAttribute("uid", user.getId());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), ByteSource.Util.bytes(user.getSalt()), getName());
            info.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
            return info;
        }
        return null;
    }

}
