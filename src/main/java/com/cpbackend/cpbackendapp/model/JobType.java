package com.cpbackend.cpbackendapp.model;

import javax.persistence.*;

@Entity
@Table(name = "jobtype")
public class JobType {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @Column
    private String description;
}
