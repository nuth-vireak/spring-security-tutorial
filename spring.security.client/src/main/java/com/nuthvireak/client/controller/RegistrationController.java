package com.nuthvireak.client.controller;

import com.nuthvireak.client.entity.User;
import com.nuthvireak.client.event.RegistrationCompletedEvent;
import com.nuthvireak.client.model.UserModel;
import com.nuthvireak.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompletedEvent(
                user,
                "url"
        ));
        return "User registered successfully";
    }
}
