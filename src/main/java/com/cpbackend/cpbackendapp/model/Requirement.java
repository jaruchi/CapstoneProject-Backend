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
    private Date createDate;

    @Column
    private Date expiredDate;

    @Column
    private Date modifiedDate;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "jobtypeid")
    @JsonIgnore
    private JobType jobType;

//    @OneToOne(mappedBy = "jobtype", orphanRemoval = true)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private JobType jobTypeData;

    public Requirement() {
    }

    public Requirement(Long id, String title, String reqDescription, Date createDate, Date expiredDate, Date modifiedDate) {
        this.id = id;
        this.title = title;
        this.reqDescription = reqDescription;
        this.createDate = createDate;
        this.expiredDate = expiredDate;
        this.modifiedDate = modifiedDate;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getReqDescription() {
        return reqDescription;
    }

    public void setReqDescription(String reqDescription) {
        this.reqDescription = reqDescription;
    }
}
