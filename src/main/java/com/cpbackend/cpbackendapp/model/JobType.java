package com.cpbackend.cpbackendapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "requirement_id")
//    private Requirement requirement;

    public JobType() {
    }

    public JobType(Long id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
