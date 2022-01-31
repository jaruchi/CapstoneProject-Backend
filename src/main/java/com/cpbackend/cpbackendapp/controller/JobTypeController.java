package com.cpbackend.cpbackendapp.controller;

import com.cpbackend.cpbackendapp.model.JobType;
import com.cpbackend.cpbackendapp.model.Requirement;
import com.cpbackend.cpbackendapp.repository.JobTypeRepository;
import com.cpbackend.cpbackendapp.service.JobTypeService;
import com.cpbackend.cpbackendapp.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class JobTypeController {

    private JobTypeService jobTypeService;
    private static final Logger LOGGER = Logger.getLogger(JobTypeController.class.getName());

    @Autowired
    public void setJobTypeService(JobTypeService jobTypeService) {
        this.jobTypeService = jobTypeService;
    }

    // http://localhost:9092/api/jobtypes
    @PostMapping(path = "/jobtypes")
    public JobType createJobType(@RequestBody JobType jobTypeObject) {
        LOGGER.info("calling createCategory method from controller");
        return jobTypeService.createJobType(jobTypeObject);
    }

    // http://localhost:9092/api/jobtypes
    @GetMapping(path = "/jobtypes")
    public List<JobType> getAllJobType() {
        LOGGER.info("calling createCategory method from controller");
        return jobTypeService.getAllJobType();
    }
}

