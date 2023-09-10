<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<jsp:useBean id="error" type="java.lang.String" scope="request" />
<jsp:useBean id="user" type="com.example.exo3.dto.UserDTO" scope="request" />

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
            <form action="" method="post">
            <% if (mode.equals("signup")) { %>
                <div class="mb-3">
                    <label for="firstname" class="form-label">Prénom* :</label>
                    <input type="text" name="firstname" id="firstname" class="form-control" required value="<%= user.getFirstName().isEmpty() ? "" : user.getFirstName() %>">
                </div>
                <div class="mb-3">
                    <label for="lastname" class="form-label">Nom* :</label>
                    <input type="text" name="lastname" id="lastname" class="form-control" required value="<%= user.getLastName().isEmpty() ? "" : user.getLastName() %>">
                </div>
                <div class="mb-3">
                    <label for="birthdate" class="form-label">Date de naissance* :</label>
                    <input type="date" name="birthdate" id="birthdate" class="form-control" required value="<%= user.getBirthDate() %>">
                </div>
                <% } %>
                <div class="mb-3">
                    <label for="email" class="form-label">Adresse email* :</label>
                    <input type="email" name="email" id="email" class="form-control" required value="<%= user.getEmail() == null ? "" : user.getEmail() %>">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Mot de passe* :</label>
                    <input type="password" name="password" id="password" class="form-control" required>
                </div>
                <% if (mode.equals("signup")) { %>
                <div class="mb-3">
                    <label for="confirm" class="form-label">Confirmez le mot de passe* :</label>
                    <input type="password" name="confirm" id="confirm" class="form-control" required>
                </div>
                <% } %>
                <hr>
                <div class="text-center">
                    <button class="btn btn-light"><%= mode.equals("signup") ? "Inscription" : "Connexion" %></button>
                </div>
                <% if(!error.isEmpty()) { %>
                <div class="m-3 rounded text-bg-danger">
                    <p class="p-2">
                        <%= error %>
                    </p>
                </div>
                <% } %>
            </form>
            <div class="text-center">
            <% if (mode.equals("signup")) { %>
                <p>Déjà inscrit ? <a href="${pageContext.request.contextPath}/auth/signin">Connectez-vous</a></p>
            <% } else { %>
                <p>Pas encore de compte ? <a href="${pageContext.request.contextPath}/auth/signup">Inscrivez-vous</a></p>
            <% } %>
            </div>
        </div>
    </div>
</main>
</body>
</html>
