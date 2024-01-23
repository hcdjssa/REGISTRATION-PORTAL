package com.spring.registration1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.registration1.entity.User;

@Repository
public interface reRepository extends JpaRepository <User,Long>{
    public User findByEmail(String email);

    public User findByActivationLink(String activationLink);
}
