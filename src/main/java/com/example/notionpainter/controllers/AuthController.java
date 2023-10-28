package com.example.notionpainter.controllers;

import com.example.notionpainter.models.User;
import com.example.notionpainter.models.request.LoginRequest;
import com.example.notionpainter.models.request.SignUpRequest;
import com.example.notionpainter.models.response.BaseResponse;
import com.example.notionpainter.models.response.LoginResponse;
import com.example.notionpainter.services.AuthService;
import com.example.notionpainter.services.AuthServiceImpl;
import com.example.notionpainter.services.UserServiceImpl;
import com.example.notionpainter.utils.ResponseMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/auth/")
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("{id}/")
    public ResponseEntity<BaseResponse<User>> get(@PathVariable long id) {
        return ResponseEntity.ok(BaseResponse.<User>builder()
                .success(true)
                .data(userService.getUserById(id))
                .message(ResponseMessages.SUCCESS)
                .build());
    }

    @PostMapping("login/")
    public ResponseEntity<BaseResponse<User>> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(BaseResponse.<User>builder()
                .success(true)
                .data(authService.login(loginRequest.getEmail(), loginRequest.getPassword()))
                .message(ResponseMessages.SUCCESS)
                .build());
    }

    @PostMapping("signup/")
    public ResponseEntity<BaseResponse<User>> signUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(BaseResponse.<User>builder()
                .success(true)
                .data(authService.signUp(signUpRequest))
                .message(ResponseMessages.SUCCESS)
                .build());
    }
}
