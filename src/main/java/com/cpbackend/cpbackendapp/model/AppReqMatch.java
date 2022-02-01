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
    // @JsonIgnore
    private Requirement requirement;

    @OneToOne
    @JoinColumn(name = "appid")
    // @JsonIgnore
    private Application application;

    public AppReqMatch() {
    }

    public AppReqMatch(Long id, Boolean accepted) {
        this.id = id;
        this.accepted = accepted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

}
