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

@WebServlet(name = "addPerson", value = "/persons/add")
public class AddPersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("errorsList", new ArrayList<>());
        req.setAttribute("person", new Person("", "", 18, ""));
        getServletContext().getRequestDispatcher("/WEB-INF/persons/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Variables pour la gestion des erreurs
        List<String> errors = new ArrayList<>();
        boolean isValid = false;
        int age = 0;

        if (req.getParameter("age").isEmpty() || req.getParameter("firstname").isEmpty() || req.getParameter("lastname").isEmpty()) {
            if (req.getParameter("firstname").isEmpty()) {
                errors.add("Le champ \"prénom\" est requis");
            }
            if (req.getParameter("lastname").isEmpty()) {
                errors.add("Le champ \"nom\" est requis");
            }
            if (req.getParameter("age").isEmpty()) {
                errors.add("Le champ \"âge\" est requis");
            }
        } else {
            age = Integer.parseInt(req.getParameter("age"));
            if (age < 18) {
                errors.add("La personne doit avoir au moins 18 ans");
                age = 18;
            } else if (age > 75) {
                errors.add("La personne est trop âgée");
                age = 18;
            } else {
                isValid = true;
            }
        }

        System.out.println("Valide : " + isValid);

        Person person = new Person(
                req.getParameter("firstname"),
                req.getParameter("lastname"),
                age,
                req.getParameter("bio")
        );

        if (isValid) {
            // Affichage des données du formulaire dans la console :
            System.out.println("--- Ajout de " + person.getFirstName() + " " + person.getLastName() + " ---");
            System.out.println("\tÂge : " + person.getAge());
            System.out.println("\tBiographie :");
            System.out.println(person.getBio());

            // Ajout de la personne :
            FakeDB.addPerson(person);

            // Renvoi sur la page des personnes :
//            req.setAttribute("personsList", FakeDB.getPersons());
//            getServletContext().getRequestDispatcher("/WEB-INF/persons/persons.jsp").forward(req, resp);

            // Plus simple : redirection vers l'URL, qui renvoie vers le doGet du servlet
            // Ici on doit utiliser un URL absolu ou "remonter" sur le slash précédent
            resp.sendRedirect( req.getContextPath() + "/persons");
//            resp.sendRedirect("../persons");

        } else {
            req.setAttribute("person", person);
            req.setAttribute("errorsList", errors);
            getServletContext().getRequestDispatcher("/WEB-INF/persons/add.jsp").forward(req, resp);
        }
    }
}
