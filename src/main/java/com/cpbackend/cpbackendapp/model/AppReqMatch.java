package com.cpbackend.cpbackendapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "appreqmatch")
public class AppReqMatch {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean accepted;

    @OneToOne
    @JoinColumn(name = "reqid")
    @JsonIgnore
    private Requirement requirement;

    @OneToOne
    @JoinColumn(name = "appid")
    @JsonIgnore
    private Application application;
}
