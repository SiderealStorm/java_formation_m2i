package com.example.exo3.database;

import com.example.exo3.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {

    // TODO remove admin after testing app
    private static final List<User> users = new ArrayList<>(List.of(new User("admin@mail.com", "admin")));

    public static List<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }
}
