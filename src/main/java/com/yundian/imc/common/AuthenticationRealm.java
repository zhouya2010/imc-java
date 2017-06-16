package com.yundian.imc.common;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class AuthenticationRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.err.println("doGetAuthorizationInfo");
        String username = (String) getAvailablePrincipal(principalCollection);
        //我们可以通过用户名从数据库获取权限/角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //权限
        Set<String> s = new HashSet<String>();
        s.add("printer:print");
        s.add("printer:query");
        info.setStringPermissions(s);
        //角色
        Set<String> r = new HashSet<String>();
        r.add("role1");
        info.setRoles(r);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.err.println("doGetAuthenticationInfo");
//用户名
        String username = (String) token.getPrincipal();
//        log.info("username:"+username);
        //密码
        String password = new String((char[])token.getCredentials());
//        log.info("password:"+password);
        //从数据库获取用户名密码进行匹配，这里为了方面，省略数据库操作
        if(!"admin".equals(username)){
            throw new UnknownAccountException();
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }
        //身份验证通过,返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());

        return aInfo;
    }
}
