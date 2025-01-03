package com.shalash.task5.controller;

import com.shalash.task5.security.JwtService;
import com.shalash.task5.repository.UserDetailsImplRepo;
import com.shalash.task5.mapper.UserMapper;
import com.shalash.task5.enitity.UserDetailsImpl;
import com.shalash.task5.model.AuthenticationRequest;
import com.shalash.task5.model.AuthenticationResponse;
import com.shalash.task5.model.UserRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private UserDetailsImplRepo userRepository;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/auth/register")
    public AuthenticationResponse register(@RequestBody @Valid UserRequest request) {
        UserDetailsImpl user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userResponseDTO(userMapper.toResponse(user))
                .build();
    }

    @PostMapping("/auth/login")
    public AuthenticationResponse authenticate(@RequestBody @Valid AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userResponseDTO(userMapper.toResponse(user))
                .build();
    }
}
