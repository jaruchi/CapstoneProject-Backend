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
    private String iconName;

    @Column
    private String illustrationPath;

    @Column
    private String description;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "requirement_id")
//    private Requirement requirement;

    public JobType() {
    }

    public JobType(Long id, String type, String description, String iconName, String illustrationPath) {
        this.id = id;
        this.iconName = iconName;
        this.illustrationPath = illustrationPath;
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

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getIllustrationPath() {
        return illustrationPath;
    }

    public void setIllustrationPath(String illustrationPath) {
        this.illustrationPath = illustrationPath;
    }
}
