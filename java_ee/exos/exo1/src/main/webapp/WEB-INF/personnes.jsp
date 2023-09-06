<%@ page import="com.example.exo1.model.Person" %><%--
  Les autres pages du site peuvent être "cachées",
  (inaccessibles en tapant le chemin du fichier .html)
  en les plaçant dans le dossier WEB-INF :
  cela force la navigation via les servlets
--%>

<%-- Récupération de la liste des personnes via le servlet --%>
<jsp:useBean id="personsList" type="java.util.ArrayList<com.example.exo1.model.Person>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%-- Import de Bootstrap --%>
    <%@include file="bootstrap-links.html" %>
    <title>Nos collaborateurs</title>
</head>
<body class="container">
    <nav class="navbar navbar-expand bg-dark">
        <div class="container-fluid">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link text-light" href="home"><span class="bi bi-house"></span> Accueil</a></li>
                <li class="nav-item"><a class="nav-link text-light" href="persons"><span class="bi bi-person"></span> Nos collaborateurs</a></li>
                <li class="nav-item"><a class="nav-link text-light" href="contact"><span class="bi bi-chat-dots"></span> Contact</a></li>
            </ul>
        </div>
    </nav>

    <h2>Nos collaborateurs</h2>
    <table class="table text-center">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Âge</th>
            </tr>
        </thead>
        <tbody>
            <% for (Person person : personsList) { %>
                <tr>
                    <td><%=person.getLastName()%></td>
                    <td><%=person.getFirstName()%></td>
                    <td><%=person.getAge()%> ans</td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
