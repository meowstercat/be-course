package com.truecoder.spring.security.payload.request;

import lombok.Data;

import java.util.Set;

@Data
public class SignUpRequest {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;

}
