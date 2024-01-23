package com.spring.registration1.service;

import org.springframework.stereotype.Service;

import com.spring.registration1.entity.User;
import com.spring.registration1.model.lmodel;

import com.spring.registration1.model.reModel;

@Service
public interface reService {

    String reUser(reModel model);

    String login(lmodel model);

    void activate(String token);

    User forgetPassword(String email);

    User forgetPassword(String email,String link,lmodel model);
}
