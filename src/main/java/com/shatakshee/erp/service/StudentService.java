package com.shatakshee.erp.service;

import com.shatakshee.erp.dto.LoginRequest;
import com.shatakshee.erp.entity.Student;
import com.shatakshee.erp.filter.JWTFilter;
import com.shatakshee.erp.helper.CustomUserDetails;
import com.shatakshee.erp.helper.JWTHelper;
import com.shatakshee.erp.repo.StudentRepo;
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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements UserDetailsService  {
    private final StudentRepo studentRepo;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;
    private final JWTHelper jwtHelper;
    private static final Logger logger = LoggerFactory.getLogger(JWTFilter.class);

    public String login(LoginRequest request) {
        Student student = studentRepo.findByEmail(request.email())
                .orElseThrow(() -> new UsernameNotFoundException("Student not found with email: " + request.email()));
        boolean matches = passwordEncoder.matches(request.password(), student.getPassword());

        if(!matches){
            return "Wrong Password or Email";
        }
        return jwtHelper.generateToken(request.email());

    }
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Loading user details for username: {}", username);
        Student student = studentRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with email: " + username));
        return new CustomUserDetails(student); // Wrapping Customer in CustomUserDetails
    }
}
