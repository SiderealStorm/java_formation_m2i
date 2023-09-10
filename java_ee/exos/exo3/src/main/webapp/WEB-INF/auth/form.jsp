<%--
  Created by IntelliJ IDEA.
  User: darkw
  Date: 09/09/2023
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>

<jsp:useBean id="mode" type="java.lang.String" scope="request" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/assets/bootstrap-links.html"%>
    <title>Authentification</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/assets/navbar.jsp" />
</header>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 p-3 rounded text-bg-secondary">
            <h2 class="display-4">
                <%= mode.equals("signup") ? "Inscription" : "Connexion" %>
            </h2>
            <hr>
            <% if (mode.equals("signup")) { %>
            <form action="" method="post">
                <div class="mb-3">
                    <label for="firstname" class="form-label">Prénom :</label>
                    <input type="text" name="firstname" id="firstname" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="lastname" class="form-label">Nom :</label>
                    <input type="text" name="lastname" id="lastname" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="birthdate" class="form-label">Date de naissance :</label>
                    <input type="date" name="birthdate" id="birthdate" class="form-control">
                </div>
                <% } %>
                <div class="mb-3">
                    <label for="email" class="form-label">Adresse email :</label>
                    <input type="email" name="email" id="email" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Mot de passe :</label>
                    <input type="password" name="password" id="password" class="form-control">
                </div>
                <%-- TODO improvement : add password confirmation --%>
<%--                <% if (mode.equals("signup")) { %>--%>
<%--                <div class="mb-3">--%>
<%--                    <label for="confirm" class="form-label">Confirmez le mot de passe :</label>--%>
<%--                    <input type="password" name="confirm" id="confirm" class="form-control">--%>
<%--                </div>--%>
<%--                <% } %>--%>
                <hr>
                <div class="text-center">
                    <button class="btn btn-light"><%= mode.equals("signup") ? "Inscription" : "Connexion" %></button>
                </div>
            </form>
            <div class="text-center">
            <% if (mode.equals("signup")) { %>
                <p>Déjà inscrit ? <a href="/auth/signin">Connectez-vous</a></p>
            <% } else { %>
                <p>Pas encore de compte ? <a href="/auth/signup">Inscrivez-vous</a></p>
            <% } %>
            </div>
        </div>
    </div>
</main>
</body>
</html>
