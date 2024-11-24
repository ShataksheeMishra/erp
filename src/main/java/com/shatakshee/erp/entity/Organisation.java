package com.shatakshee.erp.entity;

import jakarta.persistence.*;
import lombok.*;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Organisation")



public class Organisation {
    @Id
    @Column(name="organisation_id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;


}

