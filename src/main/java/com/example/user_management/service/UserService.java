package com.example.user_management.service;

import com.example.user_management.dto.UserRequest;
import com.example.user_management.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserRequest request);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
}
