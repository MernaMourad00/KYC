package com.example.kycapp2.controller;

import com.example.kycapp2.entity.User;
import com.example.kycapp2.service.serviceImpl.UserServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/users")
@Tag(
        name = "CRUD REST APIs for User Resource"
)
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {

        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServiceImpl.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userServiceImpl.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

}
