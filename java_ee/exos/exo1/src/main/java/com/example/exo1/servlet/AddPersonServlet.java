package com.example.exo1.servlet;

import com.example.exo1.fakeDB.FakeDB;
import com.example.exo1.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "addPerson", value = "/persons/add")
public class AddPersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/persons/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person();

        person.setFirstName(req.getParameter("firstname"));
        person.setLastName(req.getParameter("lastname"));
        person.setAge(Integer.parseInt(req.getParameter("age")));
        person.setBio(req.getParameter("bio"));

        // Affichage des données du formulaire dans la console :
        System.out.println("--- Ajout de " + person.getFirstName() + " " + person.getLastName() + " ---");
        System.out.println("\tÂge : " + person.getAge());
        System.out.println("\tBiographie :");
        System.out.println(person.getBio());

        // Ajout de la personne :
        FakeDB.addPerson(person);

        // Renvoi sur la page des personnes) :
        req.setAttribute("personsList", FakeDB.getPersons());
        getServletContext().getRequestDispatcher("/WEB-INF/persons/persons.jsp").forward(req, resp);
    }
}
