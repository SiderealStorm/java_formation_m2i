package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "formServlet", value = "/form")
public class ServletTest2 extends HttpServlet {

    private String initParam;

    @Override
    public void init() throws ServletException {

        // On peut récupérer des paramètres définis dans le fichier web.xml
        // via la méthode .getInitParameter("nomParamètre") du contexte
        initParam = getServletContext().getInitParameter("test");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        // Utilisation du paramètre contexte récupéré à l'initialisation
//
//        resp.setContentType("text/plain");
//
//        PrintWriter writer = resp.getWriter();
//        writer.println(initParam);

        // Génération d'une erreur mathématique
//        int calcul = 125/0;

        getServletContext().getRequestDispatcher("/WEB-INF/test2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Récupération des paramètres de la requête POST

        // La méthode .getParameter() prend en paramètre le NOM du champ du formulaire
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");

        // Tous les paramètres sont récupérés sous forme de String, il faut les parser :auth/
        double age = Double.parseDouble(req.getParameter("age"));

        System.out.println(firstName + " " + lastName + " " + age);
    }
}
