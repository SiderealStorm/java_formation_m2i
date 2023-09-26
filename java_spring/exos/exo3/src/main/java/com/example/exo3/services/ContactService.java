package com.example.exo3.services;

import com.example.exo3.entities.Contact;
import com.example.exo3.mappers.ContactMapper;
import com.example.exo3.models.ContactDTO;
import com.example.exo3.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactMapper contactMapper;
    private final ContactRepository contactRepository;

    public void sortContactList(List<Contact> contactList) {
        contactList.sort(Comparator.comparing(o -> o.getFirstName().toUpperCase()));
        contactList.sort(Comparator.comparing(o -> o.getLastName().toUpperCase()));
    }

    public List<ContactDTO> getAllContacts() {
        List<Contact> list = contactRepository.findAll();
        // Tri de la liste
        sortContactList(list);
        return list.stream().map(contactMapper::contactToContactDto).toList();
    }


    public List<ContactDTO> getContactsFilterLastname(String filter) {
        List<Contact> list = contactRepository.getAllByLastNameStartingWith(filter);
        sortContactList(list);
        return list.stream().map(contactMapper::contactToContactDto).toList();
    }

    // Dans une vraie BDD, on commence par vérifier que l'ID existe
    // avant d'appeler une méthode qui recquiert un objet entier
    public boolean isIdInDb(UUID id) {
        return contactRepository.existsById(id);
    }

    public ContactDTO getContactById(UUID id) {
        Contact foundContact = contactRepository.findById(id).orElse(null);
        return contactMapper.contactToContactDto(foundContact);
    }

    public ContactDTO addContact(ContactDTO contact) {
        Contact newContact = contactRepository.save(contactMapper.contactDtoToContact(contact));

        return contactMapper.contactToContactDto(newContact);
    }

    public boolean deleteContactById(UUID id) {
        ContactDTO foundContact = getContactById(id);

        if (foundContact != null) {
            contactRepository.deleteById(id);

            return true;
        }

        return false;
    }

    public ContactDTO editContact(UUID id, ContactDTO contact) {
        ContactDTO foundContact = getContactById(id);

        if (foundContact != null) {

            contactRepository.save(contactMapper.contactDtoToContact(contact));

            return foundContact;
        }

        return null;
    }

}
