package com.nuthvireak.client.service;

import com.nuthvireak.client.entity.User;
import com.nuthvireak.client.entity.VerificationToken;
import com.nuthvireak.client.model.UserModel;
import com.nuthvireak.client.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(User user, String token) {
        VerificationToken verificationToken =
                new VerificationToken(user, token);

    }
}

// TODO 7:03:00 Bootstrapping the Spring Security Client
