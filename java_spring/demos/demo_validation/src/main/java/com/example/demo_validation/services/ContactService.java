package com.example.demo_validation.services;

import com.example.demo_validation.entities.Contact;
import com.example.demo_validation.exceptions.ElementNotFoundException;
import com.example.demo_validation.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                // Permet de ne pas avoir à gérer l'optionnel et lever une exception personnalisée
                .orElseThrow(ElementNotFoundException::new);
    }
}
