package com.cpbackend.cpbackendapp.service;

import com.cpbackend.cpbackendapp.exception.InformationExistException;
import com.cpbackend.cpbackendapp.exception.InformationNotFoundException;
import com.cpbackend.cpbackendapp.model.Application;
import com.cpbackend.cpbackendapp.model.JobType;
import com.cpbackend.cpbackendapp.model.Requirement;
import com.cpbackend.cpbackendapp.repository.ApplicationRepository;
import com.cpbackend.cpbackendapp.repository.JobTypeRepository;
import com.cpbackend.cpbackendapp.repository.RequirementRepository;
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

        Application application = applicationRepository.findByUserIdAndAndId(userDetails.getUser().getId(),
                jobtypeId);

        if (application != null) {
            throw new InformationExistException("application for job type " + application.getJobType().getType() + " " +
                    "already exists");
        }
        Optional<JobType> jobType = jobTypeRepository.findById(jobtypeId);
        if (!jobType.isPresent()) {
            throw new InformationNotFoundException("Job Type " + jobType.get().getType() + " do not exists ");
        }
        applicationObject.setUser(userDetails.getUser());
        applicationObject.setJobType(jobType.get());
        return applicationRepository.save(applicationObject);
    }

    public Application getApplication(Long jobtypeId) {
            LOGGER.info("calling getApplication method from service");

            MyUserDetails userDetails =
                    (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Application application = applicationRepository.findByUserIdAndAndId(userDetails.getUser().getId(),
                    jobtypeId);
            if (application == null) {
                throw new InformationNotFoundException("application for job type " + application.getJobType().getType()
                        + " do not exists");
            }
            Optional<JobType> jobType = jobTypeRepository.findById(jobtypeId);
            if (!jobType.isPresent()) {
                throw new InformationNotFoundException("Job Type " + jobType.get().getType() + " do not exists ");
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

    public Application updateApplication(Long jobtypeId, Application applicationObject) {
        LOGGER.info("calling updateApplication method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Application application = applicationRepository.findByUserIdAndAndId(userDetails.getUser().getId(),
                jobtypeId);
        if (application == null) {
            throw new InformationNotFoundException("application do not exists for this job");
        }

        if (applicationObject.getHeading() != null)
            application.setHeading(applicationObject.getHeading());
//        if (requirementObject.getCreateDate() != null)
//            requirement.setCreateDate(applicationObject.getCreateDate());
//        if (requirementObject.getExpiredDate() != null)
//            requirement.setExpiredDate(applicationObject.getExpiredDate());
//        if (requirementObject.getModifiedDate() != null)
//            requirement.setModifiedDate(applicationObject.getModifiedDate());
        return applicationRepository.save(application);
    }

    public Optional<Application> deleteApplication(Long applicationId) {
        LOGGER.info("calling deleteApplication method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<Application> application = applicationRepository.findById(applicationId);

        if (application.isEmpty()) {
            throw new InformationNotFoundException("application with id : " + applicationId +
                    " not found");
        }
        applicationRepository.deleteById(application.get().getId());
        return application;
    }
}
