<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap-links.html"%>
    <title>Contenu privé</title>
</head>
<body>
<header>
   <%@ include file="navbar.html"%>
</header>
<main>
    <h2>Bienvenue sur votre profil, ${user.username} !</h2>
    <p>
        Il n'y a pas de contenu à afficher pour l'instant.
    </p>
</main>
</body>
</html>
