<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/09/2023
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>

<%-- Déclaration en JSP : --%>
<%! String prenom = "Toto"; %>
<%-- Récupération de données depuis le servlet --%>
<jsp:useBean id="prenomServlet" type="java.lang.String" scope="request" />
<jsp:useBean id="prenoms" type="java.util.ArrayList<java.lang.String>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Ajout des liens pour Bootstrap avec un import -->
    <%@ include file="bootstrap-imports.html" %>
    <title>Test 1</title>
</head>
<body>
    <main>
        <h1>Test 1</h1>
        <hr>
        <p>
            Vous êtes sur la page de test n°1.
        </p>

        <%-- Récupération de données déclarées sur la page --%>
        <p>
            Prénom dans la JSP : <b><%= prenom %></b>
        </p>

        <%-- Passage par le servlet pour récupérer des données --%>
        <p>
            Prénom sur le servlet : <b>${prenomServlet}</b>
        </p>

        <%-- Idem avec utilisation de useBean, qui permet d'utiliser des méthodes, faire des boucles... --%>
        <p>
            Prénom sur le servlet avec méthode : <b><%= prenomServlet.toUpperCase() %></b>
        </p>
        <hr>
        <p>
            Liste des prénoms :
            <ul>
                <% for (String prenom : prenoms) { %>
                <li><%= prenom %></li>
                <% } %>
            </ul>
        </p>
    </main>
</body>
</html>
