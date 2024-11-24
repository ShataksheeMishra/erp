package com.shatakshee.erp.controller;

import com.shatakshee.erp.dto.EligibleOrganisationDTO;
import com.shatakshee.erp.filter.JWTFilter;
import com.shatakshee.erp.service.StudentService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor

public class StudentController {
    private final StudentService studentService;
    private static final Logger logger = LoggerFactory.getLogger(JWTFilter.class);

    @GetMapping("/offers")
    public List<EligibleOrganisationDTO> getStudents(@RequestHeader("Authorization") String token) {



        return studentService.getAllStudents(token);
    }


}
