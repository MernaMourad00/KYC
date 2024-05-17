package com.example.kycapp2.service;

import com.example.kycapp2.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();

    User getUserByUsername(String username);

}
