package com.yundian.imc.common.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by dell on 2017/6/19.
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String role;

    public GrantedAuthorityImpl(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        System.err.println("getAuthority ==>" + role);
        return role;
    }
}
