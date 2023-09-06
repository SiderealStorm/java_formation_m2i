<%--
  Le fichier index.html doit être accessible directement
  car c'est la première page demandée par le navigateur,
  sans passer par les servlets
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <%-- Import de Bootstrap --%>
  <%@include file="WEB-INF/bootstrap-links.html" %>
  <title>Accueil</title>
</head>
<body class="container">
  <nav class="navbar navbar-expand bg-dark">
    <div class="container-fluid">
      <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link text-light" href="home"><span class="bi bi-house"></span> Accueil</a></li>
        <li class="nav-item"><a class="nav-link text-light" href="persons"><span class="bi bi-person"></span> Nos collaborateurs</a></li>
        <li class="nav-item"><a class="nav-link text-light" href="contact"><span class="bi bi-chat-dots"></span> Contact</a></li>
      </ul>
    </div>
  </nav>
  <h2>Accueil</h2>
</body>
</html>