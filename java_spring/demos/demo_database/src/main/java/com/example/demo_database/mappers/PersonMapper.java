package com.example.demo_database.mappers;

import com.example.demo_database.entities.Person;
import com.example.demo_database.models.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

// Un Mapper sert à "transformer" une entité en DTO
// On utilise MapStruc
@Mapper
public interface PersonMapper {


    // Si l'attribut de entité n'a pas le même nom dans le DTO,
    // il faut préciser les liens des attributs avec @Mapping
    @Mapping(source = "firstName", target = "name")
    // Si deux propriétés sont liées mais pas identiques,
    // il faut passer par une méthode statique du Mapper avec qualifiedByName
    @Mapping(source = "birthDate", target = "age", qualifiedByName = "convertDateToAge")
    PersonDTO personToPersonDto(Person person);

    @Mapping(source = "name", target = "firstName")
    Person personDtoToPerson(PersonDTO personDTO);

    // Méthode pour convertir l'âge en date
    // Il faut (re)nommer la méthode avec le décorateur @Named
    @Named("convertDateToAge")
    static int convertDateToAge(LocalDate date) {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - date.getYear();

        if (now.minusYears(age).isBefore(date)) {
            age--;
        }

        return age;
    }
}
