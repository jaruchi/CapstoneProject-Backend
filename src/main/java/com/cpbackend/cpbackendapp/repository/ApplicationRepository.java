package com.cpbackend.cpbackendapp.repository;

import com.cpbackend.cpbackendapp.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
    Application findByUserIdAndAndId(Long id, Long jobtypeId);

    List<Application> findByUserId(Long id);
}
