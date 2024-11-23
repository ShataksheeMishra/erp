package com.shatakshee.erp.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Placement")

public class Placement {
    @Id
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "organisation", referencedColumnName = "id")
    private Organisation organisation;

    @Column(name = "profile")
    private String profile;

    @Column(name = "description")
    private String description ;

    @Column(name = "intake")
    private int intake;

    @Column(name = "minimune_grade")
    private int minimum_grade;

}
