package com.example.exo3.database;

import com.example.exo3.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {

    private static final List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }
}
