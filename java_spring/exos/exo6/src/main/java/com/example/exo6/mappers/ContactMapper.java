package com.example.exo6.mappers;

import com.example.exo6.entities.Contact;
import com.example.exo6.models.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

// Si on veut créer soi-même le mapper,
// il devra être annoté de @Component

@Mapper
public interface ContactMapper {

    @Mapping(source = "birthDate", target = "age", qualifiedByName = "convertDateToAge")
    ContactDTO contactToContactDto(Contact contact);

    Contact contactDtoToContact(ContactDTO contactDTO);

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
