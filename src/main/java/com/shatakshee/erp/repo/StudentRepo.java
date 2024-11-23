package com.shatakshee.erp.repo;

import com.shatakshee.erp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface StudentRepo extends JpaRepository<Student, Integer>{
    Optional<Student> findByEmail(String email);
}
