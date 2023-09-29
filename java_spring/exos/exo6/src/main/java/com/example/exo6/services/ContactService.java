package com.example.exo6.services;

import com.example.exo6.entities.Contact;
import com.example.exo6.exceptions.ResourceNotFoundException;
import com.example.exo6.mappers.ContactMapper;
import com.example.exo6.models.ContactDTO;
import com.example.exo6.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;
    private final ContactMapper mapper;

    public void sortContactList(List<Contact> contactList) {
        contactList.sort(Comparator.comparing(o -> o.getFirstName().toUpperCase()));
        contactList.sort(Comparator.comparing(o -> o.getLastName().toUpperCase()));
    }

    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = repository.findAll();
        sortContactList(contacts);
        return contacts.stream().map(mapper::contactToContactDto).toList();
    }

    public boolean idIdInDb(UUID id) {
        return repository.existsById(id);
    }

    public ContactDTO getContactById(UUID id) {
        Contact foundContact = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.contactToContactDto(foundContact);
    }

    public ContactDTO addContact(ContactDTO contactDTO) {
        Contact newContact = repository.save(mapper.contactDtoToContact(contactDTO));

        return mapper.contactToContactDto(newContact);
    }

    public ContactDTO updateContact(UUID id, ContactDTO contactDTO) {
        ContactDTO foundContact = getContactById(id);

        if (foundContact != null) {
            if (contactDTO.getFirstName() != null) {
                foundContact.setFirstName(contactDTO.getFirstName());
            }
            if (contactDTO.getLastName() != null) {
                foundContact.setLastName(contactDTO.getLastName());
            }
            if (contactDTO.getEmail() != null) {
                foundContact.setEmail(contactDTO.getEmail());
            }
            if (contactDTO.getPhone() != null) {
                foundContact.setPhone(contactDTO.getPhone());
            }
            if (contactDTO.getBirthDate() != null) {
                foundContact.setBirthDate(contactDTO.getBirthDate());
            }

            repository.save(mapper.contactDtoToContact(contactDTO));

            return foundContact;
        }
        return null;
    }

    public boolean deleteContact(UUID id) {
        ContactDTO foundContact = getContactById(id);

        if (foundContact != null) {
            repository.deleteById(id);

            return true;
        }
        return false;
    }

}
