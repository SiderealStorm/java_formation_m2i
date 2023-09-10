<%@ page import="com.example.exo3.model.Contact" %>

<jsp:useBean id="contacts" type="java.util.List<com.example.exo3.model.Contact>" scope="request" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/assets/bootstrap-links.html"%>
    <title>Contacts</title>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/assets/navbar.jsp"%>
</header>
<main class="container">
    <div class="row my-3">
        <div class="col-10 offset-1 p-3">
            <h2 class="display-4">
                Vos contacts
            </h2>
            <hr>
            <% if(contacts.isEmpty()) { %>
            <div class="align-middle text-center">
                <p>Vous n'avez aucun contact</p>
            </div>
            <% } else { %>
            <table class="table table-striped align-middle text-center">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Email</th>
                        <th>Téléphone</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Contact contact : contacts) { %>
                    <tr>
                        <td><%= contact.getLastName() %></td>
                        <td><%= contact.getFirstName() %></td>
                        <td><%= contact.getEmail().isEmpty() ? "-" : contact.getEmail() %></td>
                        <td><%= contact.getPhone().isEmpty() ? "-" : contact.getPhone() %></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/contacts/details/<%= contact.getId() %>" class="btn btn-sm btn-info"><span class="bi bi-eye"></span> Détails</a>
                            <a href="${pageContext.request.contextPath}/contacts/edit/<%= contact.getId() %>" class="btn btn-sm btn-warning"><span class="bi bi-pencil-square"></span> Modifier</a>
                            <a href="${pageContext.request.contextPath}/contacts/delete/<%= contact.getId() %>" class="btn btn-sm btn-danger"><span class="bi bi-trash"></span> Supprimer
                            </a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% } %>
            <hr>
            <div class="text-end">
                <a href="${pageContext.request.contextPath}/contacts/add" class="btn btn-success"><span class="bi bi-plus-circle"></span> Ajouter un contact</a>
            </div>
        </div>
    </div>
</main>
</body>
</html>
