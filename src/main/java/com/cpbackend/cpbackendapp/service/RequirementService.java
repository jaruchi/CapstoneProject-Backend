package com.cpbackend.cpbackendapp.service;

import com.cpbackend.cpbackendapp.exception.InformationExistException;
import com.cpbackend.cpbackendapp.exception.InformationNotFoundException;
import com.cpbackend.cpbackendapp.model.JobType;
import com.cpbackend.cpbackendapp.model.Requirement;
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
public class RequirementService {

    private RequirementRepository requirementRepository;
    private JobTypeRepository jobTypeRepository;

    private static final Logger LOGGER = Logger.getLogger(RequirementService.class.getName());

    @Autowired
    public void setRequirementRepository(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    @Autowired
    public void setJobTypeRepository(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    public Requirement createRequirement(Long jobtypeId,Requirement requirementObject) {
        LOGGER.info("calling createRequirement method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Requirement requirement = requirementRepository.findByUserIdAndId(userDetails.getUser().getId(),
                jobtypeId);

        if (requirement != null) {
            throw new InformationExistException("requirement for job type " + requirement.getJobType().getType() + " already " +
                    "exists");
        }
        Optional<JobType> jobType = jobTypeRepository.findById(jobtypeId);
        if (!jobType.isPresent()) {
            throw new InformationNotFoundException("Job Type " + jobType.get().getType() + " do not exists ");
        }
            requirementObject.setUser(userDetails.getUser());
            requirementObject.setJobType(jobType.get());
            return requirementRepository.save(requirementObject);
    }

    public Requirement getRequirement(Long requirementId) {
        LOGGER.info("calling getRequirement method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Requirement requirement = requirementRepository.findByUserIdAndId(userDetails.getUser().getId(),
                requirementId);
        if (requirement == null) {
            throw new InformationNotFoundException("requirement for id "+requirementId+" do not exists");
        }
        return requirement;
    }

    public List<Requirement> getAllRequirements() {
        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Requirement> requirementList = requirementRepository.findByUserId(userDetails.getUser().getId());
        if (requirementList == null) {
            throw new InformationNotFoundException("User do not have requirements");
        }
        return requirementList;
    }

    public Requirement updateRequirement(Long requirementId, Requirement requirementObject) {
        LOGGER.info("calling updateRequirement method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Requirement requirement = requirementRepository.findByUserIdAndId(userDetails.getUser().getId(),
                requirementId);
        if (requirement == null) {
            throw new InformationNotFoundException("requirement do not exists for this job");
        }

        if (requirementObject.getTitle() != null)
            requirement.setTitle(requirementObject.getTitle());
        if (requirementObject.getReqDescription() != null)
            requirement.setReqDescription(requirementObject.getReqDescription());
//        if (requirementObject.getCreateDate() != null)
//            requirement.setCreateDate(requirementObject.getCreateDate());
//        if (requirementObject.getExpiredDate() != null)
//            requirement.setExpiredDate(requirementObject.getExpiredDate());
//        if (requirementObject.getModifiedDate() != null)
//            requirement.setModifiedDate(requirementObject.getModifiedDate());
        return requirementRepository.save(requirement);
    }

    public Requirement deleteRequirement(Long requirementId) {
        LOGGER.info("calling deleteRequirement method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Requirement requirement = requirementRepository.findByUserIdAndId(userDetails.getUser().getId(),
                requirementId);

        if (requirement==null) {
            throw new InformationNotFoundException("requirement with id : " + requirementId +
                    " not found");
        }
        requirementRepository.deleteById(requirement.getId());
        return requirement;
    }

    public List<Requirement> getOpenRequirements() {
        LOGGER.info("calling getOpenRequirements method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return requirementRepository.findMyOpenRequirements(userDetails.getUser().getId());
    }

    public List<Requirement> getFulfilledRequirements() {
        LOGGER.info("calling getOpenRequirements method from service");

        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return requirementRepository.findMyFulfilledRequirements(userDetails.getUser().getId());

    }
}
