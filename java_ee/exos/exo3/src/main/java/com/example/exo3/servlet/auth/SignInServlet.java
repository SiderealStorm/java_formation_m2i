package com.example.exo3.servlet.auth;

import com.example.exo3.database.FakeDB;
import com.example.exo3.dto.UserDTO;
import com.example.exo3.model.User;
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
        req.setAttribute("mode", "signin");
        req.setAttribute("error", "");
        req.setAttribute("user", new UserDTO());

        getServletContext().getRequestDispatcher("/WEB-INF/auth/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "";

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> foundUser = FakeDB.getUsers().stream().filter(user -> user.getEmail().equals(email)).findFirst();

        if (foundUser.isPresent()) {
            User user = foundUser.get();

            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("user", user);

                resp.sendRedirect(req.getContextPath() + "/contacts");
            } else {
                error = "Mot de passe incorrect";
            }

        } else {
            error = "Utilisateur inconnu";
        }

        if (!error.isEmpty()) {

            UserDTO dto = new UserDTO(email);

            req.setAttribute("mode", "signin");
            req.setAttribute("error", error);
            req.setAttribute("user", dto);

            getServletContext().getRequestDispatcher("/WEB-INF/auth/form.jsp").forward(req, resp);
        }
    }
}
