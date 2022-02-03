package com.cpbackend.cpbackendapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String heading;

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

    @Column
    private String appDescription;

    @ManyToOne
    @JoinColumn(name = "userid")
    //@JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "jobtypeid")
    //@JsonIgnore
    private JobType jobType;

    public Application() {
    }

    public Application(Long id, String heading, String day,  String subject,
                       String level, String pets, String ageRange, String services, String appDescription) {
        this.id = id;
        this.heading = heading;
        this.day = day;
        this.level = level;
        this.subject = subject;
        this.pets = pets;
        this.ageRange = ageRange;
        this.services = services;
        this.appDescription = appDescription;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
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

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
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
