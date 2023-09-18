<%@ page import="com.example.exo3.model.User" %>
<%! User user; %>
<% user = (User) request.getSession().getAttribute("user"); %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/home">Accueil</a>
        </li>
        <% if (user != null && user.getEmail() != null && !user.getEmail().isEmpty()) { %>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/contacts">Contacts</a>
        </li>
        <% } %>
      </ul>
      <div class="d-flex ms-auto">
        <% if (user != null && user.getEmail() != null && !user.getEmail().isEmpty()) { %>
        <span class="navbar-text mx-2 small">
            <%= user.getEmail() %>
        </span>
        <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/auth/signout">Déconnexion</a>
        <% } else { %>
        <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/auth/signin">Connexion</a>
        <% } %>
      </div>
    </div>
  </div>
</nav>