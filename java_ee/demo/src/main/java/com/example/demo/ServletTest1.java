package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "servletTest1", value = "/servlet-test1")
public class ServletTest1 extends HttpServlet {

    private String prenom;
    private List<String> prenoms;

    @Override
    public void init() throws ServletException {
        prenom = "Storm";
        prenoms = new ArrayList<>();
        prenoms.add("Zack");
        prenoms.add("Ellie");
        prenoms.add("Sun");
        prenoms.add("Hendrik");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Ajoute un attribut à la requête (nom de l'attribut + valeur)
        req.setAttribute("prenomServlet", prenom);
        req.setAttribute("prenoms", prenoms);

        // Envoi du JSP via le contexte des servlets
        getServletContext()
                // Passer le chemin du serveur
                .getRequestDispatcher("/test1.jsp")
                // envoi de la requête et de la réponse
                .forward(req, resp);
    }
}
