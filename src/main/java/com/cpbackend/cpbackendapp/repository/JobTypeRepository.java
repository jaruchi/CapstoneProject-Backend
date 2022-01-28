package com.cpbackend.cpbackendapp.repository;

import com.cpbackend.cpbackendapp.model.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType,Long> {

    JobType findByType(String type);
}
