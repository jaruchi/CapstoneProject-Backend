package com.cpbackend.cpbackendapp.repository;

import com.cpbackend.cpbackendapp.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement,Long> {
    Requirement findByUserIdAndAndId(Long id, Long jobId);
    List<Requirement> findByUserId(Long id);
}
