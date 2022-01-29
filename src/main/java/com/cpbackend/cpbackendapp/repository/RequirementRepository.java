package com.cpbackend.cpbackendapp.repository;

import com.cpbackend.cpbackendapp.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement,Long> {

    @Query("Select r from Requirement r " +
            "left join AppReqMatch a on a.requirement.id = r.id " +
            "where r.user.id=:userid " +
            "and a.application.id IS NULL")
    List<Requirement> findMyOpenRequirements(@Param("userid")Long userid);

    @Query("Select r from Requirement r " +
            "join AppReqMatch a on a.requirement.id = r.id " +
            "where r.user.id=:userid " )
    List<Requirement> findMyFulfilledRequirements(@Param("userid")Long userid);

    List<Requirement> findByUserId(Long id);
    Requirement findByUserIdAndId(Long userId, Long Id);
    Requirement findByIdAndUserIdNot(Long id, Long userId);


}
