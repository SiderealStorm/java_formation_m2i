package com.example.exo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "contact", value = "/contact")
public class ContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Envoi du JSP via le contexte des servlets
        getServletContext().getRequestDispatcher("/WEB-INF/contact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String subject = req.getParameter("subject");
        String message = req.getParameter("message");

        System.out.println("--- Message de " + firstName + " " + lastName + " ---");
        System.out.println("\tSujet : " + subject);
        System.out.println("\tMessage :");
        System.out.println(message);
    }
}
