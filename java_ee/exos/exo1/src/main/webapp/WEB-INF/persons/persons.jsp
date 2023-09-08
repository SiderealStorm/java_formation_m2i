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
    <%@include file="../bootstrap-links.html" %>
    <title>Nos collaborateurs</title>
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
        <h2 class="display-6">Nos collaborateurs</h2>
        <table class="table text-center align-middle">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Âge</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% for (int i = 0 ; i < personsList.size() ; i++) { %>
                <% Person person = personsList.get(i); %>
                    <tr>
                        <td><%=person.getLastName()%></td>
                        <td><%=person.getFirstName()%></td>
                        <td><%=person.getAge()%> ans</td>
                        <%-- On peut mettre le lien en relatif car les fichiers sont voisins --%>
                        <td><a href="persons/details/<%= i %>" class="btn btn-dark"><span class="bi bi-eye"></span> Détails</a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <div class="text-end">
            <a href="${pageContext.request.contextPath}/persons/add" class="btn btn-outline-success"><span class="bi bi-plus-circle"></span>
                 Nouveau collaborateur</a>
        </div>
    </main>
</body>
</html>
