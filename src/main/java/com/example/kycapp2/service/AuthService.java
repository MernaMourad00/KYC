package com.example.kycapp2.service;

import com.example.kycapp2.payload.LoginDTO;
import com.example.kycapp2.payload.RegisterDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    String login(LoginDTO loginDTO);
    String register(RegisterDTO registerDTO);
}
