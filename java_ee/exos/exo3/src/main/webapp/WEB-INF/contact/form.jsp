<jsp:useBean id="error" type="java.lang.String" scope="request" />
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<jsp:useBean id="contact" type="com.example.exo3.dto.ContactDTO" scope="request" />

<%! String displayMode; %>
<%-- Note : error if replacing by switch statement --%>
<% if(mode.equals("add")) {
    displayMode = "Ajouter un contact";
} else if (mode.equals("view")){
    displayMode = "Détails du contact";
} else if (mode.equals("edit")){
    displayMode = "Modifier le contact";
} else if (mode.equals("delete")){
    displayMode = "Supprimer le contact";
} else {
    displayMode = "";
}; %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/assets/bootstrap-links.html"%>
    <title><%= displayMode %></title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/assets/navbar.jsp" />
</header>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2">
            <h2 class="display-4">
                <%= displayMode %>
            </h2>
            <hr>
            <form action="<%= mode.equals("add") ? mode : "" %>" method="post">
                <input type="number" name="id" class="d-none" readonly value="<%= contact.getId() %>">
                <div class="mb-3">
                    <label for="firstname" class="form-label">Prénom* :</label>
                    <input type="text" name="firstname" id="firstname" class="form-control" required <% if(mode.equals("view") || mode.equals("delete")) { %> readonly <% } %>
                           value="<%= contact.getFirstName() %>">
                </div>
                <div class="mb-3">
                    <label for="lastname" class="form-label">Nom* :</label>
                    <input type="text" name="lastname" id="lastname" class="form-control" required <% if(mode.equals("view") || mode.equals("delete")) { %> readonly <% } %>
                           value="<%= contact.getLastName() %>">
                </div>
                <div class="mb-3">
                    <label for="birthdate" class="form-label">Date de naissance :</label>
                    <input type="date" name="birthdate" id="birthdate" class="form-control" <% if(mode.equals("view") || mode.equals("delete")) { %> readonly <% } %>
                           value="<%= contact.getBirthDate() %>">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Adresse email :</label>
                    <input type="email" name="email" id="email" class="form-control" <% if(mode.equals("view") || mode.equals("delete")) { %> readonly <% } %>
                    value="<%= contact.getEmail() %>">
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Téléphone :</label>
                    <input type="text" name="phone" id="phone" class="form-control" <% if(mode.equals("view") || mode.equals("delete")) { %> readonly <% } %>
                    value="<%= contact.getPhone() %>">
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Adresse :</label>
                    <input type="text" name="address" id="address" class="form-control" <% if(mode.equals("view") || mode.equals("delete")) { %> readonly <% } %>
                           value="<%= contact.getAddress() %>">
                </div>
                <hr>
                <div class="text-center">
                    <%-- Note : error if replacing by switch statement --%>
                    <% if(mode.equals("add")) { %>
                    <button class="btn btn-success"><span class="bi bi-plus-circle"></span> Ajouter</button>
                    <% } else if (mode.equals("edit")){ %>
                    <button class="btn btn-warning"><span class="bi bi-pencil-square"></span> Modifier</button>
                    <% } else if (mode.equals("delete")){ %>
                    <button class="btn btn-danger"><span class="bi bi-trash"></span> Supprimer</button>
                    <% } %>
                    <a href="${pageContext.request.contextPath}/contacts" class="btn btn-secondary"><span class="bi bi-arrow-clockwise"></span> Retour</a>
                </div>
                <% if(!error.isEmpty()) { %>
                <div class="m-3 rounded text-bg-danger">
                    <p class="p-2">
                        <%= error %>
                    </p>
                </div>
                <% } %>
            </form>
        </div>
    </div>
</main>
</body>
</html>

