package com.example.back.mappers;

import com.example.back.entities.Contact;
import com.example.back.models.ContactDetailsDTO;
import com.example.back.models.ContactSummaryDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Component
public class ContactMapper {

    public ContactSummaryDTO contactToContactSummaryDto(Contact contact) {
        if (contact == null) {
            return null;
        } else {
            return ContactSummaryDTO.builder()
                    .id(contact.getId())
                    .firstName(contact.getFirstName())
                    .lastName(contact.getLastName())
                    .birthDate(contact.getBirthDate())
                    .build();
        }
    }

    public List<ContactSummaryDTO> contactListToContactSummaryDtoList(List<Contact> contacts) {
        if (contacts == null) {
            return null;
        } else {
            return contacts.stream().map(this::contactToContactSummaryDto).toList();
        }
    }

    public Contact contactDetailsDtoToContact(ContactDetailsDTO dto) {
        if (dto == null) {
            return null;
        } else {
            return Contact.builder()
                    .firstName(dto.getFirstName())
                    .lastName(dto.getLastName())
                    .birthDate(dto.getBirthDate())
                    .email(dto.getEmail())
                    .phone(dto.getPhone())
                    .build();
        }
    }

    public ContactDetailsDTO contactToContactDetailsDto(Contact contact) {
        if (contact == null) {
            return null;
        } else {
            return ContactDetailsDTO.builder()
                    .id(contact.getId())
                    .firstName(contact.getFirstName())
                    .lastName(contact.getLastName())
                    .birthDate(contact.getBirthDate())
                    .age(calculateAge(contact.getBirthDate()))
                    .email(contact.getEmail())
                    .phone(contact.getPhone())
                    .build();
        }
    }

    public List<ContactDetailsDTO> contactListToContactDetailDtoList(List<Contact> contacts) {
        if (contacts == null) {
            return null;
        } else {
            return contacts.stream().map(this::contactToContactDetailsDto).toList();
        }
    }

    private Integer calculateAge(LocalDate birthDate) {
        if (birthDate == null) {
            return null;
        } else {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
    }
}
