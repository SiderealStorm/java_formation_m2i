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
        <div class="col-10 offset-1 text-bg-secondary rounded row">
            <h2 class="display-6 text-center">Contactez-nous</h2>
            <hr>
            <form action="contact" method="post" class="px-4">
                <div class="mb-3">
                    <label for="firstname" class="form-label">Votre prénom :</label>
                    <input type="text" name="firstname" id="firstname" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="lastname" class="form-label">Votre nom :</label>
                    <input type="text" name="lastname" id="lastname" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="subject" class="form-label">Sujet de votre message :</label>
                    <select name="subject" id="subject" class="form-select">
                        <option value="">--- Sélectionnez ---</option>
                        <option value="Question sur l'entreprise">Question sur l'entreprise</option>
                        <option value="Candidature spontanée">Candidature spontanée</option>
                        <option value="Problème sur le site">Problème sur le site</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="message" class="form-label">Votre message :</label>
                    <textarea name="message" id="message" cols="30" rows="5" class="form-control"></textarea>
                </div>
                <div class="mb-3 text-center">
                    <button class="btn btn-light">Envoyer</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
