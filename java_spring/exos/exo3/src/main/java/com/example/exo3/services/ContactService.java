package com.example.exo3.services;

import com.example.exo3.models.ContactDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactService {

    private final Map<UUID, ContactDTO> contacts;

    public ContactService() {
        contacts = new HashMap<>();

        ContactDTO contact1 = ContactDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Jérôme")
                .lastName("Dupont")
                .email("jdupont@mail.com")
                .phone("0320557784")
                .build();

        ContactDTO contact2 = ContactDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Julie")
                .lastName("Durand")
                .email("jdurand@mail.com")
                .phone("0321667845")
                .build();

        ContactDTO contact3 = ContactDTO.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@mail.com")
                .phone("0645315874")
                .build();

        contacts.put(contact1.getId(), contact1);
        contacts.put(contact2.getId(), contact2);
        contacts.put(contact3.getId(), contact3);
    }

    public List<ContactDTO> getAllContacts() {
        List<ContactDTO> list = new ArrayList<>(contacts.values().stream().toList());
        // Tri de la liste
        list.sort(Comparator.comparing(o -> o.getFirstName().toUpperCase()));
        list.sort(Comparator.comparing(o -> o.getLastName().toUpperCase()));
        return list;
    }

    public Optional<ContactDTO> getContactById(UUID id) {
        return contacts.values().stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public ContactDTO addContact(ContactDTO contact) {
        if (contact.getId() == null) {
            contact.setId(UUID.randomUUID());
        }

        contacts.put(contact.getId(), contact);

        return contact;
    }
}
