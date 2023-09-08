package com.example.exo2.database;

import com.example.exo2.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {

    private static final List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }
}
