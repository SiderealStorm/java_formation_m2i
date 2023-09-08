<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/09/2023
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>

<%-- Récupération de l'attribut person de la requête --%>
<jsp:useBean id="person" type="com.example.exo1.model.Person" scope="request" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../bootstrap-links.html"%>
    <title>Détails de <%= person.getFirstName() %> <%= person.getLastName() %></title>
</head>
<body>
<nav class="navbar navbar-expand bg-dark">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link text-light" href="${pageContext.request.contextPath}/home"><span class="bi bi-house"></span> Accueil</a></li>
            <li class="nav-item"><a class="nav-link text-light" href="${pageContext.request.contextPath}/persons"><span class="bi bi-person"></span> Nos collaborateurs</a></li>
            <li class="nav-item"><a class="nav-link text-light" href="${pageContext.request.contextPath}/contact"><span class="bi bi-chat-dots"></span> Contact</a></li>
        </ul>
    </div>
</nav>

<main class="container my-3">
    <h2 class="display-6 mb-3">Détails de <%= person.getFirstName() %> <%= person.getLastName() %></h2>

    <div>
        <p>
            Prénom : <%= person.getFirstName() %>
        </p>
        <p>
            Nom : <%= person.getLastName() %>
        </p>
        <p>
            Âge : <%= person.getAge() %> ans
        </p>
    </div>
    <% if (person.getBio() != null && !person.getBio().isEmpty()) { %>
    <h3>Biographie :</h3>
    <p>
        <%= person.getBio() %>
    </p>
    <% } %>

</main>
</body>
</html>
