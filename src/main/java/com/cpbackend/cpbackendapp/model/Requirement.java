package com.cpbackend.cpbackendapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "requirements")
public class Requirement {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String reqDescription;

    @Column
    private String day;

    @Column
    private String level;

    @Column
    private String subject;

    @Column
    private String pets;

    @Column
    private String ageRange;

    @Column
    private String services;

    @ManyToOne
    @JoinColumn(name = "userid")
    // @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "jobtypeid")
    //@JsonIgnore
    private JobType jobType;

//    @OneToMany(mappedBy = "category", orphanRemoval = true)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private List<JobType> jobTypeList;

    public Requirement() {
    }

    public Requirement(Long id, String title, String reqDescription, String subject,
                       String day, String level, String pets, String ageRange, String services) {
        this.id = id;
        this.title = title;
        this.reqDescription = reqDescription;
        this.day = day;
        this.subject = subject;
        this.level = level;
        this.pets = pets;
        this.ageRange = ageRange;
        this.services = services;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getReqDescription() {
        return reqDescription;
    }

    public void setReqDescription(String reqDescription) {
        this.reqDescription = reqDescription;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
