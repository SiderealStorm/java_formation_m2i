package com.example.exo1.fakeDB;

import com.example.exo1.model.Person;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {

    private static final List<Person> personDB = new ArrayList<>();

    public static List<Person> getPersons() {
        return personDB;
    }

    public static void addPerson(Person person) {
        personDB.add(person);
    }

}
