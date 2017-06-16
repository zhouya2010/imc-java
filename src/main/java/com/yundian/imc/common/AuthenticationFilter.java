package com.yundian.imc.common;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class AuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        return super.createToken(request, response);
//        String username = getUsername(request);
//        String password = getPassword(request);
////        String captchaId = getCaptchaId(request);
////        String captcha = getCaptcha(request);
//        boolean rememberMe = isRememberMe(request);
//        String host = getHost(request);
//        return new AuthenticationToken(username, password, rememberMe, host);
    }
}
