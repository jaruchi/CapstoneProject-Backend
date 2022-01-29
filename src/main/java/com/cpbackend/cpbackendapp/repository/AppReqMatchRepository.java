package com.cpbackend.cpbackendapp.repository;

import com.cpbackend.cpbackendapp.model.AppReqMatch;
import com.cpbackend.cpbackendapp.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppReqMatchRepository extends JpaRepository<AppReqMatch,Long> {
    AppReqMatch findByApplicationId(Long applicationId);
    AppReqMatch findByRequirementId(Long requirementId);
}
