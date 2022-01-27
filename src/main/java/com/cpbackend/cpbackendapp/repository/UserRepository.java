package com.cpbackend.cpbackendapp.repository;

import com.cpbackend.cpbackendapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //to register
    Boolean existsByEmailAddress(String userEmailAddress);

    // to login
    User findUserByEmailAddress(String userEmailAddress);
}
