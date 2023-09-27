package com.example.exo6.mappers;

import com.example.exo6.entities.Contact;
import com.example.exo6.models.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper
public interface ContactMapper {

    Contact contactDtoToContact(ContactDTO contactDTO);

    @Mapping(source = "birthDate", target = "age", qualifiedByName = "convertDateToAge")
    ContactDTO contactToContactDto(Contact contact);

    @Named("convertDateToAge")
    static Integer convertDateToAge(LocalDate date) {
        LocalDate now = LocalDate.now();
        if (date != null) {
            int age = now.getYear() - date.getYear();

            if (now.minusYears(age).isBefore(date)) {
                age--;
            }
            return age;
        }
        return 0;
    }
}
