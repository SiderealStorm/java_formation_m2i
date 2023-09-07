package com.example.exo1.servlet;

import com.example.exo1.fakeDB.FakeDB;
import com.example.exo1.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "persons", value = "/persons")
public class PersonsServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // Initialisation et remplissage de la liste de personnes
        FakeDB.addPerson(new Person("Jacques", "Dupont", 46));
        FakeDB.addPerson(new Person("Julie", "Durand", 28));
        FakeDB.addPerson(new Person("John", "Doe", 33));
        FakeDB.addPerson(new Person("Jack", "Doe", 33));
        FakeDB.addPerson(new Person("Jane", "Doe", 33));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Ajout de la liste des personnes dans la réponse HTTP, via la création de l'attribut personsList
        req.setAttribute("personsList", FakeDB.getPersons());

        // Envoi du JSP via le contexte des servlets
        getServletContext().getRequestDispatcher("/WEB-INF/persons/persons.jsp").forward(req, resp);
    }
}
