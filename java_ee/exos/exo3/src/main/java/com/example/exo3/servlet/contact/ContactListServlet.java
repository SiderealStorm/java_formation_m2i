package com.example.exo3.servlet.contact;

import com.example.exo3.database.FakeDB;
import com.example.exo3.model.Contact;
import com.example.exo3.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "contactListServlet", value = "/contacts")
public class ContactListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if (user != null) {
            List<Contact> contacts = user.getContacts();

            // TODO improvement : sort list by contact names ??

            req.setAttribute("contacts", contacts);

            getServletContext().getRequestDispatcher("/WEB-INF/contact/list.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/signin");
        }
    }
}
