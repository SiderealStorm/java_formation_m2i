<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Ajout des liens pour Bootstrap avec un import -->
    <%@ include file="bootstrap-imports.html" %>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<ul>
    <li><a href="monServlet">Mon Servlet texte</a></li>
    <li><a href="monservlet-html">Mon Servlet HTML</a></li>
    <%--  Ecriture d'une valeur Java dans un JSP  --%>
    <li>Date du jour : <%= LocalDate.now() %></li>
    <%--  Ecrire un bloc de code  --%>
    <% for (int i = 0 ; i < 5 ; i++) { %>
        <li>Item n° <%= i %></li>
    <% } %>
</ul>
</body>
</html>