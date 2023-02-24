package com.nuthvireak.client.event.listener;

import com.nuthvireak.client.entity.User;
import com.nuthvireak.client.event.RegistrationCompletedEvent;
import com.nuthvireak.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompletedEventListener implements ApplicationListener<RegistrationCompletedEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompletedEvent event) {
        // Create a verification token for the user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(user, token);
        // Send the email to the user
    }
}
