package com.example.exo3.servlet.auth;

import com.example.exo3.database.FakeDB;
import com.example.exo3.dto.UserDTO;
import com.example.exo3.model.Contact;
import com.example.exo3.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet(name = "signUpServlet", value = "/auth/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "signup");
        req.setAttribute("error", "");
        req.setAttribute("user", new UserDTO("", "", null, ""));

        getServletContext().getRequestDispatcher("/WEB-INF/auth/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "";

        String email = req.getParameter("email");

        Optional<User> foundUser = FakeDB.getUsers().stream().filter(user -> user.getEmail().equals(email)).findFirst();

        if (foundUser.isEmpty()) {

            if(req.getParameter("password").equals(req.getParameter("confirm"))) {

                User user = new User(
                        req.getParameter("firstname"),
                        req.getParameter("lastname"),
                        LocalDate.parse(req.getParameter("birthdate")),
                        req.getParameter("email"),
                        req.getParameter("password")
                );

                FakeDB.addUser(user);

                req.getSession().setAttribute("user", user);

                resp.sendRedirect(req.getContextPath() + "/contacts");
            } else {
                error = "Le mot de passe et la confirmation doivent être identiques";
            }

        } else {
            error = "Cet email est déjà lié à un compte";
        }

        if(!error.isEmpty()) {
            UserDTO dto = new UserDTO(
                    req.getParameter("firstname"),
                    req.getParameter("lastname"),
                    LocalDate.parse(req.getParameter("birthdate")),
                    req.getParameter("email")
            );

            req.setAttribute("mode", "signup");
            req.setAttribute("error", error);
            req.setAttribute("user", dto);

            getServletContext().getRequestDispatcher("/WEB-INF/auth/form.jsp").forward(req, resp);
        }
    }
}
