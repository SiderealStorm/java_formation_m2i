<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%--<jsp:useBean id="user" type="com.example.exo2.model.User" scope="request" />--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap-links.html"%>
    <title>Accueil</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/home">Accueil</a></li>
                    <%--                    <% if(user != null) { %>--%>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/private">Profil</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/auth/signout">Déconnexion</a></li>
                    <%--                    <% } else { %>--%>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/auth/signup">Inscription</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/auth/signin">Connexion</a></li>
                    <%--                    <% } %>--%>
                </ul>
            </div>
        </div>
    </nav>
</header>
<main>
    <h2>Accueil du site</h2>
</main>
</body>
</html>
