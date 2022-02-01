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

    public Application(Long id, String heading, String appDescription) {
        this.id = id;
        this.heading = heading;
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
}
