package com.example.back.services;

import com.example.back.entities.Contact;
import com.example.back.mappers.ContactMapper;
import com.example.back.models.ContactDetailsDTO;
import com.example.back.models.ContactSummaryDTO;
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

    public List<ContactDetailsDTO> getAllContactsDtoList() {
        return mapper.contactListToContactDetailDtoList(repository.findAll());
    }

    public ContactDetailsDTO getContactById(Long id) {
        Optional<Contact> foundContact = repository.findById(id);

        return foundContact.map(mapper::contactToContactDetailsDto).orElse(null);
    }

    public ContactDetailsDTO saveNewContact(ContactDetailsDTO contactDto) {
        Contact newContact = mapper.contactDetailsDtoToContact(contactDto);
        repository.save(newContact);
        return mapper.contactToContactDetailsDto(newContact);
    }

}
