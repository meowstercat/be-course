package com.truecoder.spring.service;

import com.truecoder.spring.security.payload.request.LoginRequest;
import com.truecoder.spring.security.payload.request.SignUpRequest;
import com.truecoder.spring.security.payload.response.JwtResponse;
import com.truecoder.spring.security.payload.response.MessageResponse;

public interface AuthService {
    JwtResponse login(LoginRequest loginRequest);

    MessageResponse register(SignUpRequest signUpRequest);
}
