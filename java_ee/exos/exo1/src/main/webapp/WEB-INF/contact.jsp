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
<body>
    <nav>
        <ul>
            <li><a href="home">Accueil</a></li>
            <li><a href="persons">Nos collaborateurs</a></li>
            <li><a href="contact">Contact</a></li>
        </ul>
    </nav>
    <h2>Contactez-nous</h2>
</body>
</html>
