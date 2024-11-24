package com.shatakshee.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name="student_id")
    private int studentId;

    @Column(name = "roll_number", nullable = false, unique = true)
    private String rollNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "photograph_path")
    private String photo;

    @Column(name = "cgpa", nullable = false)
    private int cgpa;

    @Column(name = "total_credits", nullable = false)
    private int credits;

    @Column(name = "graduation_year", nullable = false)
    private Year graduationYear;

    @ManyToOne
    @JoinColumn(name = "domain", referencedColumnName = "domain_id")
    private Domains domain;

    @ManyToOne
    @JoinColumn(name = "specialisation", referencedColumnName = "specialisation_id")
    private Specialisation specialisation;

    @ManyToOne
    @JoinColumn(name = "placement_id", referencedColumnName = "placement_id")
    private Placement placement_id;

    @Column(name = "password", nullable = false)
    private String password;



}
