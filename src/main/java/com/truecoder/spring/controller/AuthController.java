package com.truecoder.spring.controller;

import com.truecoder.spring.security.payload.request.LoginRequest;
import com.truecoder.spring.security.payload.request.SignUpRequest;
import com.truecoder.spring.security.payload.response.JwtResponse;
import com.truecoder.spring.security.payload.response.MessageResponse;
import com.truecoder.spring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        JwtResponse Response = authService.login(loginRequest);
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        MessageResponse messageResponse = authService.register(signUpRequest);
        return new ResponseEntity<>(messageResponse,HttpStatus.OK);
    }
}
