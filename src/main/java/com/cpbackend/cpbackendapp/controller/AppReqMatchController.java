package com.cpbackend.cpbackendapp.controller;

import com.cpbackend.cpbackendapp.model.AppReqMatch;
import com.cpbackend.cpbackendapp.model.Application;
import com.cpbackend.cpbackendapp.service.AppReqMatchService;
import com.cpbackend.cpbackendapp.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class AppReqMatchController {

    private AppReqMatchService appReqMatchService;
    private static final Logger LOGGER = Logger.getLogger(AppReqMatchController.class.getName());

    @Autowired
    public void setAppReqMatchService(AppReqMatchService appReqMatchService){
        this.appReqMatchService = appReqMatchService;
    }

    // http://localhost:9092/api/match/application/{applicationid}/requirement/{requirementid}
    @PostMapping(path = "/match/application/{applicationId}/requirement/{requirementId}")
    public AppReqMatch createAppToReqMatch(@PathVariable(value = "applicationId") Long applicationId,
                                         @PathVariable(value = "requirementId") Long requirementId) {
        LOGGER.info("calling createAppToReqMatch method from controller");
        return appReqMatchService.createAppToReqMatch(applicationId,requirementId);
    }

    // http://localhost:9092/api/match/requirement/{requirementId}/application/{applicationId}
    @PostMapping(path = "/match/requirement/{requirementId}/application/{applicationId}")
    public AppReqMatch createReqToAppMatch(@PathVariable(value = "applicationId") Long applicationId,
                                         @PathVariable(value = "requirementId") Long requirementId) {
        LOGGER.info("calling createReqToAppMatch method from controller");
        return appReqMatchService.createReqToAppMatch(applicationId,requirementId);
    }

}
