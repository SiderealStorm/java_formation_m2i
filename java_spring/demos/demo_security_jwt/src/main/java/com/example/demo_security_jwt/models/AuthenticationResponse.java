package com.example.demo_security_jwt.models;

import lombok.Builder;
import lombok.Data;

// DTO contentant le token JWT
@Data
@Builder
public class AuthenticationResponse {

    private String token;
    private String type = "JWT";
}
