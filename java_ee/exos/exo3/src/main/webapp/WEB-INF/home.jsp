<%@ page import="com.example.exo3.model.User" %><%--
  Created by IntelliJ IDEA.
  User: darkw
  Date: 09/09/2023
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/assets/bootstrap-links.html"%>
    <title>Accueil</title>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/assets/navbar.jsp"%>
</header>
<main class="container">
    <h1>
        Bienvenue dans ContactBook
    </h1>
    <p>
        ContactBook vous permet de gérer vos contacts : adresses, téléphones, mails, anniversaires...
    </p>

    <p>
        <a href="${pageContext.request.contextPath}/auth/signup">Inscrivez-vous</a>
        dès aujourd'hui pour profiter de nos services, ou
        <a href="${pageContext.request.contextPath}/auth/signin">connectez-vous</a>
        pour gérer vos contacts.
    </p>
</main>
</body>
</html>
