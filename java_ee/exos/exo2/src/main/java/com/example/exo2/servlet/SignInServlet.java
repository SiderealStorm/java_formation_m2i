package com.example.exo2.servlet;

import com.example.exo2.database.FakeDB;
import com.example.exo2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "signInServlet", value = "/auth/signin")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.setAttribute("mode", "signin");

        getServletContext().getRequestDispatcher("/WEB-INF/auth-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Utilisation d'un stream et d'un Optional pour vérifier l'existance de l'utilisateur
        Optional<User> foundUser = FakeDB.getUsers().stream().filter(user -> user.getUsername().equals(username)).findFirst();

        // TODO gérer les erreurs d'autentification
        // Si l'utilisateur a été trouvé
        if (foundUser.isPresent()) {
            System.out.println("User found");
            // On vérifie que le mot de passe est correct
            if (foundUser.get().getPassword().equals(password)) {
                // On passe l'utilisateur à la session
                req.getSession().setAttribute("user", foundUser.get());
                System.out.println("User connected");

                // On redirige vers la page privée
                resp.sendRedirect(req.getContextPath() + "/private");
            } else {
                doGet(req, resp);
                System.out.println("Invalid password");
            }
        } else {
            doGet(req, resp);
            System.out.println("User not found");
        }
    }
}
