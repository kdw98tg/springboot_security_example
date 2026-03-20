package com.example.bst.oauth2_sequrity_example.security.entity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.bst.oauth2_sequrity_example.user.entity.User;

public class PrincipalDetails implements UserDetails {

    private User user = null;

    public PrincipalDetails(User _user) {
        this.user = _user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> result = new ArrayList<>();

        result.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });

        return result;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
