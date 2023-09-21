package com.example.demo_database.services;

import com.example.demo_database.entities.Person;
import com.example.demo_database.mappers.PersonMapper;
import com.example.demo_database.models.PersonDTO;
import com.example.demo_database.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

// Annotations Spring
@Service
@Primary
// Annotation Lombok
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDTO> listPersons() {
        return personRepository
                .findAll()
                .stream()
                .map(personMapper::personToPersonDto)
                .toList();
    }

    public PersonDTO addPerson(PersonDTO personDTO) {
        Person person = personMapper.personDtoToPerson(personDTO);
        Person savedPerson = personRepository.save(person);

        return personMapper.personToPersonDto(savedPerson);

//        // Syntaxe courte :
//        return personMapper.personToPersonDto(personRepository.save(personMapper.personDtoToPerson(personDTO)));
    }

}
