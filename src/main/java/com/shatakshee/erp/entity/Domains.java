package com.shatakshee.erp.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Domains")
public class Domains {
    @Id
    @Column(name="domain_id")
    private int domain_id;

    @Column(name = "program", nullable = false)
    private String program;

    @Column(name = "batch")
    private int batch;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "qualification")
    private String qualification;



}
