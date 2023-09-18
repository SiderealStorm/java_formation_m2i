package com.example.demo_bases.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("EN")
public class GreetingsServiceEn implements GreetingsService {
    @Override
    public String sayHello() {
        return "Hello everyone";
    }
}
