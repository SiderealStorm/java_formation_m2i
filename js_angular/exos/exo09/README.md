# Exercice Angular J

Réaliser, via Angular, une application permettant, dans un composant, d'obtenir l'affichage d'un alphabet dont la lettre changera toutes les 1 seconde pour aller de la lettre A à la lettre Z. 

Pour ce faire, vous ferez usage de : 
- Un service qui, dans une de ses méthodes, retournera un observable dont le rôle est l'envoi de nombres allant de 1 à 26
- Un composannt qui, suite à l'abonnement à l'observable, transformera les valeurs à la volée via un opérateur RxJs (map) dans le but d'alimenter l'affichage de l'alphabet en temps réel au sein d'un paragraphe du style :
    ```HTML
    <p>
        Lettre actuelle : <b>{{ maLettre }}</b>
    </p>
    ```