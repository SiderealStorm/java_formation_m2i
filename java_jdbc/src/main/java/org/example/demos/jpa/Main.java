package org.example.demos.jpa;

import org.example.demos.jpa.demos.Bases;
import org.example.demos.jpa.demos.RelationsJPA;

public class Main {
    public static void main(String[] args) {

        // Bases :
//        Bases.insertExample();
//        Bases.findExample();
//        Bases.removeExample();
//        Bases.createQueryExample();
//        Bases.namedParameterExample();

//        Bases.closeEmf();

        // Relations :
//        RelationsJPA.oneToOneExample();
//        RelationsJPA.oneToManyExample();
        RelationsJPA.manyToManyExample();

        RelationsJPA.closeEmf();
    }

}
