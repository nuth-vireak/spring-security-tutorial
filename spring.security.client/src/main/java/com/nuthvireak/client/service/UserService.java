package com.nuthvireak.client.service;

import com.nuthvireak.client.entity.User;
import com.nuthvireak.client.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(User user, String token);
}
