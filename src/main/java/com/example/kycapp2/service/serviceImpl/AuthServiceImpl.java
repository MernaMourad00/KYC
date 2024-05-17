package com.example.kycapp2.service.serviceImpl;

import com.example.kycapp2.entity.User;
import com.example.kycapp2.exception.ConflictException;
import com.example.kycapp2.exception.InvalidCredentials;
import com.example.kycapp2.payload.LoginDTO;
import com.example.kycapp2.payload.RegisterDTO;
import com.example.kycapp2.repository.UserRepository;
import com.example.kycapp2.security.JwtTokenProvider;
import com.example.kycapp2.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDTO loginDTO) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUsernameOrEmail(),
                            loginDTO.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenProvider.generateToken(authentication);
            return token;
        } catch (AuthenticationException ex) {
            throw new InvalidCredentials("User not found with username or email : " + loginDTO.getUsernameOrEmail() +" password: "+loginDTO.getPassword());
        }
    }

    @Override
    public String register(RegisterDTO registerDTO) {

        //check if user exists
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            throw new ConflictException(HttpStatus.BAD_REQUEST,"username already exists");
        }

        if(userRepository.existsByEmail(registerDTO.getEmail())){
            throw new ConflictException(HttpStatus.BAD_REQUEST,"email already exists");
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setGender(registerDTO.getGender());
        user.setBirthdate(registerDTO.getBirthdate());
        user.setRole("USER");
        user.setMobileNumber(registerDTO.getMobileNumber());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setNationalId(registerDTO.getNationalId());

        userRepository.save(user);


        return "user registered successfully";
    }
}
