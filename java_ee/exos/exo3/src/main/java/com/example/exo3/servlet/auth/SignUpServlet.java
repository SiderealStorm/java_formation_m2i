package com.example.exo3.servlet.auth;

import com.example.exo3.database.FakeDB;
import com.example.exo3.model.User;
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
        req.setAttribute("mode", "signup");

        getServletContext().getRequestDispatcher("/WEB-INF/auth/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        Optional<User> foundUser = FakeDB.getUsers().stream().filter(user -> user.getEmail().equals(email)).findFirst();

        if (foundUser.isEmpty()) {
            User user = new User(
                    req.getParameter("firstname"),
                    req.getParameter("lastname"),
                    req.getParameter("email"),
                    req.getParameter("password")
            );

            req.getSession().setAttribute("user", user);

            resp.sendRedirect(req.getContextPath() + "/contacts");
        } else {
            // TODO generate error message
            // TODO return pre-filled form

            doGet(req, resp);
        }
    }
}
