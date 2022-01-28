package com.cpbackend.cpbackendapp.controller;

import com.cpbackend.cpbackendapp.model.Requirement;
import com.cpbackend.cpbackendapp.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(path="/api")
public class RequirementController {

    private RequirementService requirementService;
    private static final Logger LOGGER = Logger.getLogger(RequirementController.class.getName());

    @Autowired
    public void setRequirementService(RequirementService requirementService){
        this.requirementService = requirementService;
    }
    // http://localhost:9092/api/requirements/jobtype/{jobtypeid}
    @GetMapping(path = "/requirements/jobtype/{jobtypeId}")
    public Requirement getRequirement(@PathVariable(value = "jobtypeId") Long jobtypeId) {
        LOGGER.info("calling getRequirement for a job type method from controller");
        return requirementService.getRequirement(jobtypeId);
    }

    // http://localhost:9092/api/requirements/jobtype/{jobtypeid}
    @PostMapping(path = "/requirements/jobtype/{jobtypeId}")
    public Requirement createRequirement(@PathVariable(value = "jobtypeId") Long jobtypeId,
                                         @RequestBody Requirement requirementObject) {
        LOGGER.info("calling createRequirement method from controller");
        return requirementService.createRequirement(jobtypeId,requirementObject);
    }

    // http://localhost:9092/api/requirements
    @GetMapping(path = "/requirements")
    public List<Requirement> getAllRequirements() {
        LOGGER.info("calling getAllRequirements method from controller");
        return requirementService.getAllRequirements();
    }

    // http://localhost:9092/api/requirements/jobtype/{jobtypeid}
    @PutMapping(path = "/requirements/jobtype/{jobtypeId}")
    public Requirement updateRequirement(@PathVariable(value = "jobtypeId") Long jobtypeId,
                                         @RequestBody Requirement requirementObject){
        LOGGER.info("calling updateRequirement method from controller");
        return requirementService.updateRequirement(jobtypeId,requirementObject);
    }

    // http://localhost:9092/api/requirements/{requirementid}
    @DeleteMapping(path="/requirements/{requirementId}")
    public Optional<Requirement> deleteRequirement(@PathVariable(value = "requirementId") Long requirementId){
        LOGGER.info("calling deleteRequirement method from controller");
        return requirementService.deleteRequirement(requirementId);
    }
}
