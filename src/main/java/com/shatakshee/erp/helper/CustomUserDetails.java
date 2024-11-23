package com.shatakshee.erp.helper;


import com.shatakshee.erp.entity.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Student student;

    public CustomUserDetails(Student student) {
        this.student = student;
    }

    @Override
    public String getUsername() {
        return student.getEmail(); // Spring uses this as the username
    }

    @Override
    public String getPassword() {
        return student.getPassword(); // Already encrypted if using bcrypt
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Implement roles if needed, or return an empty list
        // return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        return null;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}