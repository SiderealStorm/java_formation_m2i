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
<body>
  <nav>
    <ul>
      <li><a href="home">Accueil</a></li>
      <li><a href="products">Nos produits</a></li>
      <li><a href="contact">Contact</a></li>
    </ul>
  </nav>
  <p>
    Page d'accueil
  </p>
</body>
</html>