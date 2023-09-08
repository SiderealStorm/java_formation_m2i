package com.example.exo1.servlet;

import com.example.exo1.fakeDB.FakeDB;
import com.example.exo1.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "detailsServlet",
        value = "/persons/details/*"
)
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = null;
        String pathInfo = req.getPathInfo();

        // Récupération de la personne en "BDD"
        if(pathInfo != null && !pathInfo.isEmpty()) {
            // On retire le premier caractère du pathInfo (slash)
            int id = Integer.parseInt(pathInfo.substring(1));

            // On vérifie que l'ID est correct
            if (id <= FakeDB.getPersons().size()) {
                person = FakeDB.getPersons().get(id);

                req.setAttribute("person", person);

                getServletContext().getRequestDispatcher("/WEB-INF/persons/details.jsp").forward(req, resp);
            } else {
                // Sinon on redirige vers la liste des personnes
                resp.sendRedirect(req.getContextPath() + "/persons");
            }
        }

    }
}
