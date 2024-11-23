package com.shatakshee.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Specialisation")
public class Specialisation {
    @Id
    @Column(name="specialisation_id")
    private int specialisation_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "year")
    private Year year;

    @Column(name = "credits_required")
    private int credits_required;
}
