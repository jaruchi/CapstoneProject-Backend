package com.cpbackend.cpbackendapp.service;

import com.cpbackend.cpbackendapp.exception.InformationExistException;
import com.cpbackend.cpbackendapp.exception.InformationNotFoundException;
import com.cpbackend.cpbackendapp.model.AppReqMatch;
import com.cpbackend.cpbackendapp.model.Application;
import com.cpbackend.cpbackendapp.model.Requirement;
import com.cpbackend.cpbackendapp.repository.AppReqMatchRepository;
import com.cpbackend.cpbackendapp.repository.ApplicationRepository;
import com.cpbackend.cpbackendapp.repository.JobTypeRepository;
import com.cpbackend.cpbackendapp.repository.RequirementRepository;
import com.cpbackend.cpbackendapp.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AppReqMatchService {

    private AppReqMatchRepository appReqMatchRepository;
    private ApplicationRepository applicationRepository;
    private RequirementRepository requirementRepository;

    private static final Logger LOGGER = Logger.getLogger(AppReqMatchService.class.getName());

    @Autowired
    public void setAppReqMatchRepository(AppReqMatchRepository appReqMatchRepository) {
        this.appReqMatchRepository = appReqMatchRepository;
    }

    @Autowired
    public void setApplicationRepository(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Autowired
    public void setRequirementRepository(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    public AppReqMatch createAppToReqMatch(Long applicationId, Long requirementId) {

        if(appReqMatchRepository.findByApplicationId(applicationId) !=null
                || appReqMatchRepository.findByRequirementId(requirementId)!=null){
            throw new InformationNotFoundException("application is accepted by someone else");
        }

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Application application = applicationRepository.findByUserIdAndId(userDetails.getUser().getId(),
                applicationId);
        if (application == null) {
            throw new InformationNotFoundException("application for id"+ applicationId+ "do not exists");
        }

        Requirement requirement = requirementRepository.findByIdAndUserIdNot(requirementId,
                userDetails.getUser().getId());
        if (requirement == null) {
            throw new InformationNotFoundException("requirement for id"+ requirementId+ "do not exists");
        }

        AppReqMatch appreqmatchObject = new AppReqMatch();

//        if(application.getJobType().getId()==requirement.getJobType().getId()){
//            appreqmatchObject.setAccepted(true);
//        }else{
//            throw new InformationNotFoundException("There is no match found");
//        }

        appreqmatchObject.setApplication(application);
        appreqmatchObject.setRequirement(requirement);
        return appReqMatchRepository.save(appreqmatchObject);

    }

    public AppReqMatch createReqToAppMatch(Long applicationId, Long requirementId) {

        if(appReqMatchRepository.findByApplicationId(applicationId) !=null
                || appReqMatchRepository.findByRequirementId(requirementId)!=null){
            throw new InformationNotFoundException("application is accepted by someone else");
        }

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Application application = applicationRepository.findByIdAndUserIdNot(userDetails.getUser().getId(),
                applicationId);
        if (application == null) {
            throw new InformationNotFoundException("application for id"+ applicationId+ "do not exists");
        }

        Requirement requirement = requirementRepository.findByUserIdAndId(requirementId,
                userDetails.getUser().getId());
        if (requirement == null) {
            throw new InformationNotFoundException("requirement for id"+ requirementId+ "do not exists");
        }

        AppReqMatch appreqmatchObject = new AppReqMatch();

//        if(application.getJobType().getId()==requirement.getJobType().getId()){
//            appreqmatchObject.setAccepted(true);
//        }else{
//            throw new InformationNotFoundException("There is no match found");
//        }

        appreqmatchObject.setApplication(application);
        appreqmatchObject.setRequirement(requirement);
        return appReqMatchRepository.save(appreqmatchObject);
    }

    public List<AppReqMatch> getAllMatchedRequirements() {
        LOGGER.info("calling getAllMatchedRequirements method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return appReqMatchRepository.findMatchedRequirements(userDetails.getUser().getId());
    }

    public List<AppReqMatch> getAllMatchedApplications() {
        LOGGER.info("calling getAllMatchedApplications method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return appReqMatchRepository.findMatchedApplications(userDetails.getUser().getId());
    }
}
