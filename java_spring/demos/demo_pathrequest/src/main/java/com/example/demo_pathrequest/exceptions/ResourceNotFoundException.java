package com.example.demo_pathrequest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Classe pour générer l'erreur 404
// Annotation Spring pour définir le type de réponse (ici erreur 404)
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

}
