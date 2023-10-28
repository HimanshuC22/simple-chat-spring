package com.example.notionpainter.services;

import com.example.notionpainter.models.User;

public interface UserService {
    User getUserById(long id);
    User getUserByEmail(String email);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(long id);

}
