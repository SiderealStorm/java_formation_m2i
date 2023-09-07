package com.example.demo_01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// On peut définir plusieurs URL pour un même servlet en lui passant sous forme de tableau
// En utilisant une astérisque, l'URL peut se terminer par n'importe quoi
@WebServlet(name = "multiRoutesServlet", value = {"/multi-routes", "/multi", "/multi/*"})
public class MultiRoutesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain");

        resp.getWriter().println("Servlet multi-routes" +
                "\nvaleur du pathInfo :" +
                // .getPathInfo() retourne le "reste" de l'URL (= partie correspondant à *)
                req.getPathInfo());
        }
}
