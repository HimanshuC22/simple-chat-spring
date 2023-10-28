package com.example.notionpainter.services;

import com.example.notionpainter.exceptions.UserAlreadyExistsException;
import com.example.notionpainter.exceptions.UserNotFoundException;
import com.example.notionpainter.models.request.SignUpRequest;
import com.example.notionpainter.models.User;
import com.example.notionpainter.models.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public User login(String email, String password) {
        User user = userService.getUserByEmail(email);
        if(user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User signUp(SignUpRequest signUpRequest) {
        if(userService.getUserByEmail(signUpRequest.getEmail()) != null) {
            throw new UserAlreadyExistsException("User already exists");
        }
        return userService.createUser(User.builder()
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .build());
    }

    @Override
    public User changePassword(String email, String oldPassword, String newPassword) {
        return null;
    }
}
