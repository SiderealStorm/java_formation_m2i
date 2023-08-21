package org.example.demos.jpa;

import org.example.demos.jpa.entity.Demo;

public class Main {
    public static void main(String[] args) {
        Demo.insertExemple();
        Demo.findExemple();
        Demo.removeExemple();
        Demo.customQueryExample();
    }

}
