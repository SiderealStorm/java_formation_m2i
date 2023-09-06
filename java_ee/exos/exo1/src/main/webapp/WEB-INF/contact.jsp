<%--
  Les autres pages du site peuvent être "cachées",
  (inaccessibles en tapant le chemin du fichier .html)
  en les plaçant dans le dossier WEB-INF :
  cela force la navigation via les servlets
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%-- Import de Bootstrap --%>
    <%@include file="bootstrap-links.html" %>
    <title>Contact</title>
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
    <h2>Contactez-nous</h2>
</body>
</html>
