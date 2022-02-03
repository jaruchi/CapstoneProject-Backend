package com.cpbackend.cpbackendapp.service;

import com.cpbackend.cpbackendapp.exception.InformationExistException;
import com.cpbackend.cpbackendapp.exception.InformationNotFoundException;
import com.cpbackend.cpbackendapp.model.Application;
import com.cpbackend.cpbackendapp.model.JobType;
import com.cpbackend.cpbackendapp.model.Requirement;
import com.cpbackend.cpbackendapp.repository.ApplicationRepository;
import com.cpbackend.cpbackendapp.repository.JobTypeRepository;
import com.cpbackend.cpbackendapp.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private JobTypeRepository jobTypeRepository;

    private static final Logger LOGGER = Logger.getLogger(ApplicationService.class.getName());

    @Autowired
    public void setApplicationRepository(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Autowired
    public void setJobTypeRepository(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    public Application createApplication(Long jobtypeId,Application applicationObject) {
        LOGGER.info("calling createApplication method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        Application application = applicationRepository.findByUserIdAndId(userDetails.getUser().getId(),
//                jobtypeId);
//
//        if (application != null) {
//            throw new InformationExistException("application for job type " + application.getJobType().getType() + " " +
//                    "already exists");
//        }
        Optional<JobType> jobType = jobTypeRepository.findById(jobtypeId);
        if (!jobType.isPresent()) {
            throw new InformationNotFoundException("Job Type " + jobType.get().getType() + " do not exists ");
        }
        applicationObject.setUser(userDetails.getUser());
        applicationObject.setJobType(jobType.get());
        return applicationRepository.save(applicationObject);
    }

    public Application getApplication(Long applicationId) {
            LOGGER.info("calling getApplication method from service");

            MyUserDetails userDetails =
                    (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Application application = applicationRepository.findByUserIdAndId(userDetails.getUser().getId(),
                    applicationId);
            if (application == null) {
                throw new InformationNotFoundException("application for id " + application.getId()
                        + " do not exists");
            }
            return application;
        }

    public List<Application> getAllApplications() {
        LOGGER.info("calling getAllApplications method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Application> applicationList = applicationRepository.findByUserId(userDetails.getUser().getId());
        if (applicationList == null) {
            throw new InformationNotFoundException("User do not have any applications");
        }

        return applicationList;
    }

    public Application updateApplication(Long applicationId, Application applicationObject) {
        LOGGER.info("calling updateApplication method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Application application = applicationRepository.findByUserIdAndId(userDetails.getUser().getId(),
                applicationId);
        if (application == null) {
            throw new InformationNotFoundException("application do not exists for this job");
        }

        //if (applicationObject.getHeading() != null)
        application.setHeading(applicationObject.getHeading());
        application.setAppDescription(applicationObject.getAppDescription());
        application.setDay(applicationObject.getDay());
        application.setSubject(applicationObject.getSubject());
        application.setLevel(applicationObject.getLevel());
        application.setPets(applicationObject.getPets());
        application.setAgeRange(applicationObject.getAgeRange());
        application.setServices(applicationObject.getServices());

        //if (applicationObject.etHeading() != null)
        //if (applicationObject.getHeading() != null)
        //if (applicationObject.getHeading() != null)
       // if (applicationObject.getHeading() != null)
        //if (applicationObject.)
        return applicationRepository.save(application);
    }

    public Application deleteApplication(Long applicationId) {
        LOGGER.info("calling deleteApplication method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Application application = applicationRepository.findByUserIdAndId(userDetails.getUser().getId(),applicationId);

        if (application==null) {
            throw new InformationNotFoundException("application with id : " + applicationId +
                    " not found");
        }
        applicationRepository.deleteById(application.getId());
        return application;
    }

    public List<Application> getOpenApplications() {
        LOGGER.info("calling getOpenApplications method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return applicationRepository.findMyOpenApplications(userDetails.getUser().getId());
    }

    public List<Application> getFulfilledApplications() {
        LOGGER.info("calling getFulfilledApplications method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return applicationRepository.findMyFulfilledApplications(userDetails.getUser().getId());
    }

    public List<Application> getOthersJobApplications(Long jobtypeId){
        LOGGER.info("calling getOthersJobApplications method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return applicationRepository.findOthersOpenedApplications(jobtypeId,userDetails.getUser().getId() );
    }

}
