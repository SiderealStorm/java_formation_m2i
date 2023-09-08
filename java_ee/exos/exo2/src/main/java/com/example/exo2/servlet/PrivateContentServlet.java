package com.example.exo2.servlet;

import com.example.exo2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "privateContentServlet", value = "/private")
public class PrivateContentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Récupération de l'utilisateur depuis la session
        User user = (User) req.getSession().getAttribute("user");

        if (user != null) {
            // Si un utilisateur est connecté
            req.setAttribute("user", user);

            getServletContext().getRequestDispatcher("/WEB-INF/private.jsp").forward(req, resp);
        } else {
            // Sinon on renvoie la page de connexion
            resp.sendRedirect(req.getContextPath() + "/auth/signin");
        }
    }
}
