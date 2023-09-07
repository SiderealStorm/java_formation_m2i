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
    <h2 class="display-6">Accueil</h2>
  </main>
</body>
</html>