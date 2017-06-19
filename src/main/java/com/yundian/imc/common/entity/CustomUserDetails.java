package com.yundian.imc.common.entity;

import com.yundian.imc.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(final User _user) {
        this.user = _user;
    }

    public CustomUserDetails() {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> grntdAuths = new HashSet<>();
        String[] roles = user.getPermission().getRole().split(",");
        Arrays.stream(roles).forEach(role -> {
            System.err.println("GrantedAuthority ==>" + role);
            GrantedAuthorityImpl grantedAuthority = new GrantedAuthorityImpl(role);
            grntdAuths.add(grantedAuthority);
        });
        return grntdAuths;
    }

    @Override
    public String getPassword() {
        System.err.println("getPassword ==>" + user.getPassword());
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (Optional.ofNullable(user).isPresent()) {
            return user.getEnable();
        }
        return false;
    }
}
