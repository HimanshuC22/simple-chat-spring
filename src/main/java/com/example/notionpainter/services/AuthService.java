package com.example.notionpainter.services;

import com.example.notionpainter.models.request.SignUpRequest;
import com.example.notionpainter.models.User;
import com.example.notionpainter.models.response.LoginResponse;

public interface AuthService {

    User login(String email, String password);
    User signUp(SignUpRequest signUpRequest);
    User changePassword(String email, String oldPassword, String newPassword);
}
