<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/09/2023
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>

<jsp:useBean id="errorsList" type="java.util.List<java.lang.String>" scope="request" />
<jsp:useBean id="person" type="com.example.exo1.model.Person" scope="request" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../bootstrap-links.html"%>
    <title>Ajouter un contact</title>
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
    <div class="col-10 offset-1 text-bg-secondary rounded row">
        <h2 class="display-6 text-center">Ajouter un collaborateur</h2>
        <hr>
        <form action="${pageContext.request.contextPath}/persons/add" method="post" class="px-4">
            <div class="mb-3">
                <label for="firstname" class="form-label">Prénom :</label>
                <input type="text" name="firstname" id="firstname" class="form-control" value="<%= person.getFirstName() %>">
            </div>
            <div class="mb-3">
                <label for="lastname" class="form-label">Nom :</label>
                <input type="text" name="lastname" id="lastname" class="form-control" value="<%= person.getLastName() %>">
            </div>
            <div class="mb-3">
                <label for="age" class="form-label">Âge :</label>
                <input type="number" name="age" id="age" class="form-control" value="<%= person.getAge() %>">
            </div>
            <div class="mb-3">
                <label for="bio" class="form-label">Biographie :</label>
                <textarea name="bio" id="bio" cols="30" rows="10" class="form-control"><%= person.getBio() %></textarea>
            </div>
            <div class="mb-3 text-center">
                <button class="btn btn-light">Envoyer</button>
            </div>

            <% if(errorsList != null && !errorsList.isEmpty()) { %>
            <hr>
            <div class="text-center align-middle text-bg-danger rounded">
                <% for(String error : errorsList) { %>
                    <p class="p-2 m-0">
                        <%= error %>
                    </p>
                <% } %>
            </div>
            <% } %>
        </form>
    </div>
</main>
</body>
</html>
