package com.spring.registration1.service;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.spring.registration1.entity.User;
import com.spring.registration1.model.lmodel;
import com.spring.registration1.model.reModel;

import com.spring.registration1.repository.reRepository;

@Service
public class reServiceImpl implements reService {

    @Autowired
    private reRepository rep;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String reUser(reModel model) {
        User user = new User();
        user.setFname(model.getFname());
        user.setLname(model.getLname());
        user.setEmail(model.getEmail());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        rep.save(user);
        return "localhost:8080/activate/"+user.getActivationLink();
    }

    @Override
    public String login(lmodel model) {
        
        User user1 = rep.findByEmail(model.getEmail()); 
        if(user1 != null && passwordEncoder.matches(model.getPassword(), user1.getPassword())){
            return "logged in"; 
        }
        return "wrong fields";
    }

    @Override
    public void activate(String token) {
        User user = rep.findByActivationLink(token);
        user.setStatus("active");
        rep.save(user);
    }

    @Override
    public User forgetPassword(String email) {

        User user = rep.findByEmail(email);
        String link = UUID.randomUUID().toString();
        user.setForgotpasswordLink(link);
        rep.save(user);
        return user;
    }
    
    @Override
    
    public User forgetPassword(String email,String link,lmodel model) {
        
        User user = rep.findByEmail(email);
        if(user.getForgotpasswordLink().equals(link)){
            String password = model.getPassword();
            user.setPassword(passwordEncoder.encode(password)); 
            rep.save(user);
            
        }
        return user;
    }
    
}
