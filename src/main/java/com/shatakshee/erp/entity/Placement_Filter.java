package com.shatakshee.erp.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Placement_Filter")
public class Placement_Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="placement_filter_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "placement", referencedColumnName = "placement_id")
    private Placement placement;

    @ManyToOne
    @JoinColumn(name = "specialisation", referencedColumnName = "specialisation_id")
    private Specialisation specialisation;

    @ManyToOne
    @JoinColumn(name = "domain", referencedColumnName = "domain_id")
    private Domains domain;
}
