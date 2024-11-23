package com.shatakshee.erp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static java.lang.String.format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class StudentService implements UserDetailsService  {
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;
    private final JWTHelper jwtHelper;
    private static final Logger logger = LoggerFactory.getLogger(JWTFilter.class);

    public String login(LoginRequest request) {
        Customer customer = getCustomer(request.email());
        boolean matches = passwordEncoder.matches(request.password(), customer.getPassword());
        if(!matches){
            return "Wrong Password or Email";
        }
        return jwtHelper.generateToken(request.email());

    }
}
