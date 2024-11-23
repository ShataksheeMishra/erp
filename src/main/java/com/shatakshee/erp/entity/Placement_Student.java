package com.shatakshee.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Placement_Student")

public class Placement_Student {
    @Id
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "placement_id", referencedColumnName = "id")
    private Placement placement_id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student_id;


    @Column(name = "cv_application", nullable = false)
    private String description ;

    @Column(name = "about")
    private String about ;

    @Column(name = "acceptance")
    private String acceptance ;

    @Column(name = "comments")
    private String comments ;

    @Column(name = "date")
    private Date date ;

}
