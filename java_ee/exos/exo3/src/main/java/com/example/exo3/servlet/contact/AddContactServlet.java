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
import java.time.LocalDate;

@WebServlet(name = "addContactServlet", value = "/contacts/add")
public class AddContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if (user != null) {
            ContactDTO dto = new ContactDTO(0, "", "", null, "", "", "");

            req.setAttribute("contact", dto);
            req.setAttribute("mode", "add");

            getServletContext().getRequestDispatcher("/WEB-INF/contact/form.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/signin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String dateString = req.getParameter("birthdate");
        LocalDate birthdate = dateString.isEmpty() ? null : LocalDate.parse(dateString);
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        // TODO improvement : change to Address object
        String address = req.getParameter("address");

        // TODO improvement : check phone with a RegEx ? + return pre-filled form and error message if problem with phone
//        String patterns = "^[+]{1}[1-9]{1}\\d{1,2}[(]{1}[1-9]{1}\\d{0,2}[)]{1}\\d{6,10}$"
//                + "^[+]{1}[1-9]{1}\\d{9,12}$"
//                + "^[0]{1}[1-9]{1}\\d{8}$";

        Contact contact = new Contact(
                firstName,
                lastName,
                birthdate,
                email,
                phone,
                address
        );

        user.addContact(contact);

        resp.sendRedirect(req.getContextPath() + "/contacts");

    }
}
