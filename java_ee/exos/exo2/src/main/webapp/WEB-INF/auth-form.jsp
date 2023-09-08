<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>

<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<%--<jsp:useBean id="user" type="com.example.exo2.model.User" scope="request" />--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap-links.html"%>
    <title>Authentification</title>
</head>
<body>
<header>
    <%@include file="navbar.html"%>
</header>
<main>
    <h2><% if(mode.equals("signin")) { %> Connexion <% } else { %> Créer un compte <% } %></h2>
    <form action="" method="post">
        <div>
            <label for="username">Nom d'utilisateur :</label>
            <input type="text" name="username" id="username" required>
        </div>
        <div>
            <label for="password">Mot de passe :</label>
            <input type="password" name="password" id="password" required>
        </div>
        <div>
            <button>Envoyer</button>
        </div>
    </form>
    <% if (mode.equals("signin")) {%>
    <p>
        Pas encore de compte ? <a href="signup">Inscrivez-vous</a>
    </p>
    <% } else {%>
    <p>
        Déjà un compte ? <a href="signin">Connectez-vous</a>
    </p>
    <% } %>
</main>
</body>
</html>
