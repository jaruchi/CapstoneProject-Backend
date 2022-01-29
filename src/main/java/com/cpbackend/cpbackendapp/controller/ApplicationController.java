package com.cpbackend.cpbackendapp.controller;

import com.cpbackend.cpbackendapp.model.Application;
import com.cpbackend.cpbackendapp.model.Requirement;
import com.cpbackend.cpbackendapp.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(path="/api")
public class ApplicationController {

    private ApplicationService applicationService;
    private static final Logger LOGGER = Logger.getLogger(ApplicationController.class.getName());

    @Autowired
    public void setApplicationService(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    // http://localhost:9092/api/applications/{applicationid}
    @GetMapping(path = "/applications/{applicationId}")
    public Application getApplication(@PathVariable(value = "applicationId") Long applicationId) {
        LOGGER.info("calling getApplication for a job type method from controller");
        return applicationService.getApplication(applicationId);
    }

    // http://localhost:9092/api/applications/jobtype/{jobtypeid}
    @PostMapping(path = "/applications/jobtype/{jobtypeId}")
    public Application createApplication(@PathVariable(value = "jobtypeId") Long jobtypeId,
                                         @RequestBody Application applicationObject) {
        LOGGER.info("calling createApplication method from controller");
        return applicationService.createApplication(jobtypeId,applicationObject);
    }

    // http://localhost:9092/api/applications
    @GetMapping(path = "/applications")
    public List<Application> getAllApplications() {
        LOGGER.info("calling getAllApplications method from controller");
        return applicationService.getAllApplications();
    }

    // http://localhost:9092/api/applications/{applicationid}
    @PutMapping(path = "/applications/{applicationId}")
    public Application updateApplication(@PathVariable(value = "applicationId") Long applicationId,
                                         @RequestBody Application applicationObject){
        LOGGER.info("calling updateApplication method from controller");
        return applicationService.updateApplication(applicationId,applicationObject);
    }

    // http://localhost:9092/api/applications/{applicationid}
    @DeleteMapping(path="/applications/{applicationId}")
    public Application deleteApplication(@PathVariable(value = "applicationId") Long applicationId){
        LOGGER.info("calling deleteApplication method from controller");
        return applicationService.deleteApplication(applicationId);
    }


    // http://localhost:9092/api/applications/open
    @GetMapping(path="/applications/open")
    public List<Application> getOpenApplications(){
        LOGGER.info("calling getOpenApplications method from controller");
        return applicationService.getOpenApplications();
    }

    // http://localhost:9092/api/applications/fulfilled
    @GetMapping(path="/applications/fulfilled")
    public List<Application> getFulfilledApplications(){
        LOGGER.info("calling getFulfilledApplications method from controller");
        return applicationService.getFulfilledApplications();
    }

}
