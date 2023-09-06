package com.example.exo1.servlet;

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

    // Déclaration d'une liste de personnes
    private List<Person> persons;

    @Override
    public void init() throws ServletException {
        // Initialisation et remplissage de la liste de personnes
        persons = new ArrayList<>();
        persons.add(new Person("Jacques", "Dupont", 46));
        persons.add(new Person("Julie", "Durand", 28));
        persons.add(new Person("John", "Doe", 33));
        persons.add(new Person("Jack", "Doe", 33));
        persons.add(new Person("Jane", "Doe", 33));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Ajout de la liste des personnes dans la réponse HTTP,
        // via la création de l'attribut personsList
        req.setAttribute("personsList", persons);

        // Envoi du JSP via le contexte des servlets
        getServletContext().getRequestDispatcher("/WEB-INF/personnes.jsp").forward(req, resp);
    }
}
