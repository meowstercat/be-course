package com.truecoder.spring.security.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String email;
    private String username;
    private List<String> roles;

    public JwtResponse(String token, Integer id, String email, String username, List<String> roles) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.username = username;
        this.roles = roles;
    }
}
