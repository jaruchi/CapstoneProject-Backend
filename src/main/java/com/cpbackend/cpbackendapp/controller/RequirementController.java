package com.cpbackend.cpbackendapp.controller;

import com.cpbackend.cpbackendapp.model.Requirement;
import com.cpbackend.cpbackendapp.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    // http://localhost:9092/api/requirements/{requirementid}
    @GetMapping(path = "/requirements/{requirementId}")
    public Requirement getRequirement(@PathVariable(value = "requirementId") Long requirementId) {
        LOGGER.info("calling getRequirement for a job type method from controller");
        return requirementService.getRequirement(requirementId);
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

    // http://localhost:9092/api/requirements/{requirementid}
    @PutMapping(path = "/requirements/{requirementId}")
    public Requirement updateRequirement(@PathVariable(value = "requirementId") Long requirementId,
                                         @RequestBody Requirement requirementObject){
        LOGGER.info("calling updateRequirement method from controller");
        return requirementService.updateRequirement(requirementId,requirementObject);
    }

    // http://localhost:9092/api/requirements/{requirementid}
    @DeleteMapping(path="/requirements/{requirementId}")
    public Requirement deleteRequirement(@PathVariable(value = "requirementId") Long requirementId){
        LOGGER.info("calling deleteRequirement method from controller");
        return requirementService.deleteRequirement(requirementId);
    }

    // http://localhost:9092/api/openrequirements/
    @GetMapping(path="/requirements/opened")
    public List<Requirement> getOpenRequirements(){
        LOGGER.info("calling getOpenRequirements method from controller");
        return requirementService.getOpenRequirements();
    }

    // http://localhost:9092/api/openrequirements/
    @GetMapping(path="/requirements/fulfilled")
    public List<Requirement> getFulfilledRequirements(){
        LOGGER.info("calling getFulfilledRequirements method from controller");
        return requirementService.getFulfilledRequirements();
    }
}
