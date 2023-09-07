<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/09/2023
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout personne</title>
</head>
<body>
<main>
    <%-- action = chemin du servlet (value) visé --%>
    <%-- method = type de méthode qui sera utilisée dans le servlet --%>
    <form action="form" method="post">
        <div>
            <label for="firstname">Prénom :</label>
            <input type="text" name="firstname" id="firstname">
        </div>
        <div>
            <label for="lastname">Nom :</label>
            <input type="text" name="lastname" id="lastname">
        </div>
        <div>
            <label for="age">Âge :</label>
            <input type="number" min="0" max="150" step="0.5" name="age" id="age">
        </div>
        <button>Envoyer</button>
    </form>
</main>
</body>
</html>
