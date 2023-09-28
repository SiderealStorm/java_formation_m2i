package com.example.demo_security_httpbasic.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/private")
@RequiredArgsConstructor
public class PrivateRestController {

    @GetMapping
    public String getHello() {
        return "Hello World from the private endpoint!";
    }
}
