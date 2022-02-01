package com.cpbackend.cpbackendapp.repository;

import com.cpbackend.cpbackendapp.model.Application;
import com.cpbackend.cpbackendapp.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {

    @Query("Select app from Application app " +
            "left join AppReqMatch a on a.application.id = app.id " +
            "where app.user.id=:userid " +
            "and a.requirement.id IS NULL")
    List<Application> findMyOpenApplications(@Param("userid")Long userid);

    @Query("Select app from Application app " +
            "join AppReqMatch a on a.application.id = app.id " +
            "where app.user.id=:userid " )
    List<Application> findMyFulfilledApplications(@Param("userid")Long userid);

    List<Application> findByUserId(Long id);
    Application findByUserIdAndId(Long id, Long applicationId);
    Application findByIdAndUserIdNot(long id, Long userId);

//    @Query("Select app from Application app " +
//         "left join AppReqMatch arm on arm.application.id = app.id " +
//         "where app.user.id <> :userid " +
//         "and app.jobType.id =:jobtypeid")

    @Query("Select app from Application app "  +
            "where app.user.id <> :userid " +
            "and app.jobType.id =:jobtypeid "+
            "and app.id not in (Select arm.application.id from AppReqMatch arm)")
    List<Application> findOthersOpenedApplications(@Param("jobtypeid")Long jobtypeid, @Param("userid")Long userid);


}
