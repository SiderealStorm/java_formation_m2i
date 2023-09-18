package com.example.exo3.servlet.contact;

import com.example.exo3.dto.ContactDTO;
import com.example.exo3.model.Contact;
import com.example.exo3.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "deleteContactServlet", value = "/contacts/delete/*")
public class DeleteContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if (user != null) {
            int id = Integer.parseInt(req.getPathInfo().substring(1));

            Optional<Contact> foundContact = user.getContacts().stream().filter(contact -> contact.getId() == id).findFirst();

            if (foundContact.isPresent()) {
                Contact contact = foundContact.get();

                ContactDTO dto = new ContactDTO(
                        contact.getId(),
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getBirthDate(),
                        contact.getEmail(),
                        contact.getPhone(),
                        contact.getAddress()
                );

                req.setAttribute("error", "");
                req.setAttribute("mode", "delete");
                req.setAttribute("contact", dto);

                getServletContext().getRequestDispatcher("/WEB-INF/contact/form.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getPathInfo() + "/contacts");
            }

        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/signin");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        int id = Integer.parseInt(req.getPathInfo().substring(1));

        Optional<Contact> foundContact = user.getContacts().stream().filter(contact -> contact.getId() == id).findFirst();

        if (foundContact.isPresent()) {
            user.removeContact(foundContact.get());
        }

        resp.sendRedirect(req.getContextPath() + "/contacts");
    }
}
