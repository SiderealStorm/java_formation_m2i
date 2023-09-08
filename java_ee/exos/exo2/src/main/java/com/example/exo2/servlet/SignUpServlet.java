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

@WebServlet(name = "signUpServlet", value = "/auth/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.setAttribute("mode", "signup");

        getServletContext().getRequestDispatcher("/WEB-INF/auth-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Utilisation d'un stream et d'un Optional pour vérifier l'existance de l'utilisateur
        Optional<User> foundUser = FakeDB.getUsers().stream().filter(user -> user.getUsername().equals(username)).findFirst();

        // Si pas d'utilisateur à ce nom
        if (foundUser.isEmpty()) {
            // On ajoute le nouvel utilisateur
            User user = new User(username, password);
            FakeDB.addUser(user);

            // On "connecte" l'utilisateur en l'envoyant à la session
            req.getSession().setAttribute("user", user);
            System.out.println("New User connected");

            // On redirige vers la page privée
            resp.sendRedirect(req.getContextPath() + "/private");
        } else {
            // TODO message d'erreur : l'utilisateur existe déjà
            System.out.println("User already exists");
            doGet(req, resp);
        }
    }
}
