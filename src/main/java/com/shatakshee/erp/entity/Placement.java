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
    @Column(name="placement_id")
    private int placement_id;

    @ManyToOne
    @JoinColumn(name = "organisation", referencedColumnName = "organisation_id")
    private Organisation organisation;

    @Column(name = "profile")
    private String profile;

    @Column(name = "description")
    private String description ;

    @Column(name = "intake")
    private int intake;

    @Column(name = "minimum_grade")
    private int minimum_grade;

}
