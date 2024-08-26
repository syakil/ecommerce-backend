package com.belajar.ecommerce.security.services;

import com.belajar.ecommerce.models.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.security.config.http.MatcherType.regex;
import static sun.awt.geom.Order3.split;

@Data
public class UserDetailsImpl implements UserDetails {

    private String username;
    private String email;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String role;

    public UserDetailsImpl(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(user.getName(), user.getEmail(), user.getPassword(), user.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(StringUtils.hasText(role)) {
            String[] splits = role.replaceAll(" ","").split(",");
            for(String split : splits) {
                authorities.add(new SimpleGrantedAuthority(split));
            }
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
//        return UserDetails.super.isEnabled();
        return true;
    }
}
