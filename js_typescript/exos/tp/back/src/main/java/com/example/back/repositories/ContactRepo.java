package com.example.back.repositories;

import com.example.back.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepo extends JpaRepository<Contact, Long> {

    boolean existsById(Long id);
    Optional<Contact> findById(Long id);
}
