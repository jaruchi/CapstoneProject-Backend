package com.cpbackend.cpbackendapp.service;

import com.cpbackend.cpbackendapp.exception.InformationExistException;
import com.cpbackend.cpbackendapp.model.JobType;
import com.cpbackend.cpbackendapp.repository.JobTypeRepository;
import com.cpbackend.cpbackendapp.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class JobTypeService {

    private JobTypeRepository jobTypeRepository;
    private static final Logger LOGGER = Logger.getLogger(JobTypeService.class.getName());

    @Autowired
    public void setJobTypeRepository(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    public JobType createJobType(JobType jobTypeObject) {
        LOGGER.info("calling createJobType method from service");

        JobType jobType = jobTypeRepository.findByType(jobTypeObject.getType());
        if(jobType!=null){
           throw new InformationExistException("Job Type " + jobType.getType() + " already exists");
        }else{
            return jobTypeRepository.save(jobTypeObject);
        }
    }

    public List<JobType> getAllJobType() {
        LOGGER.info("calling getAllJobType method from service");
        return jobTypeRepository.findAll();
    }
}
