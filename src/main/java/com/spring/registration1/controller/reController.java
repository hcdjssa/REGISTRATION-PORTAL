package com.spring.registration1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.registration1.entity.User;
import com.spring.registration1.model.lmodel;
import com.spring.registration1.model.reModel;
import com.spring.registration1.service.reService;

@RestController
public class reController {
    @Autowired
    private reService service;
    
    @PostMapping("/register")
    public String reUser(@RequestBody reModel model){
        String link =  service.reUser(model);
        return link;
         
        
    }
    @PostMapping("/login")
    public String login(@RequestBody lmodel model){
        String a = service.login(model);
        return a;
    }
    @GetMapping("/home")
    public String home(){
        return "hello world!";
    }

    @PostMapping("/activate/{token}")
    public String activate(@PathVariable("token") String token){
        service.activate(token);
        return "activated";
    }

    @PostMapping("/forgotPassword/{email}")
    public User forgetPassword(@PathVariable("email") String email){
        return  service.forgetPassword(email);
        
    }
    @PostMapping("/forgotPassword/{email}/{link}")
    public User forgetPassword(@PathVariable("email") String email,@PathVariable("link")String link,@RequestBody lmodel model){
        return service.forgetPassword(email,link,model);
        
    }

}
