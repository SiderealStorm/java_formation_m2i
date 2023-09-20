package com.example.exo3.models;

import lombok.Getter;

@Getter
public enum DisplayMode {
    ADD("add"),
    VIEW("view"),
    EDIT("edit"),
    DELETE("delete");

    private final String value;

    DisplayMode(String value) {
        this.value = value;
    }

}
