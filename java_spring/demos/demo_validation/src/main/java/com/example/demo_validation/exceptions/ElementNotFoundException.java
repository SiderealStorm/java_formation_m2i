package com.example.demo_validation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Autre manière de gérer l'erreur 404 :
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Element not found")
public class ElementNotFoundException extends RuntimeException {
}
