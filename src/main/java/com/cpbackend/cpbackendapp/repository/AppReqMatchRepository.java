package com.cpbackend.cpbackendapp.repository;

import com.cpbackend.cpbackendapp.model.AppReqMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppReqMatchRepository extends JpaRepository<AppReqMatch,Long> {
    AppReqMatch findByApplicationId(Long applicationId);
    AppReqMatch findByRequirementId(Long requirementId);

    @Query("Select arm from AppReqMatch arm " +
            "join Application a on a.id = arm.application.id " +
            "where a.user.id=:userid " )
    List<AppReqMatch> findMatchedApplications(@Param("userid")Long userid);

    @Query("Select arm from AppReqMatch arm " +
            "join Requirement r on r.id = arm.requirement.id " +
            "where r.user.id=:userid " )
    List<AppReqMatch>  findMatchedRequirements(@Param("userid")Long userid);



}
