package com.example.demo_validation.repositories;

import com.example.demo_validation.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
