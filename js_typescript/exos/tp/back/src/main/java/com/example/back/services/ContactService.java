package com.example.back.services;

import com.example.back.entities.Contact;
import com.example.back.mappers.ContactMapper;
import com.example.back.models.ContactDTO;
import com.example.back.repositories.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepo repository;
    private final ContactMapper mapper;

    public List<ContactDTO> getAllContactsDtoList() {
        return mapper.contactListToContactDtoList(repository.findAll());
    }

    public Contact findContactById(Long id) {
        Optional<Contact> foundContact = repository.findById(id);

        return foundContact.orElse(null);
    }

    public ContactDTO saveNewContact(ContactDTO contactDto) {
        Contact newContact = mapper.contactDtoToContact(contactDto);
        repository.save(newContact);
        return mapper.contactToContactDto(newContact);
    }

    public ContactDTO editContact(Long id, ContactDTO contactDTO) {
        Contact contact = findContactById(id);
        if (contact != null) {
            if (contactDTO.getFirstName() != null) {
                contact.setFirstName(contactDTO.getFirstName());
            }

            if (contactDTO.getLastName() != null) {
                contact.setLastName(contactDTO.getLastName());
            }

            if (contactDTO.getBirthDate() != null) {
                contact.setBirthDate(contactDTO.getBirthDate());
            }

            if (contactDTO.getEmail() != null) {
                contact.setEmail(contactDTO.getEmail());
            }

            if (contactDTO.getPhone() != null) {
                contact.setPhone(contactDTO.getPhone());
            }

            contact = repository.save(contact);

            return mapper.contactToContactDto(contact);
        } else {
            return null;
        }
    }

    public boolean deleteContactById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
