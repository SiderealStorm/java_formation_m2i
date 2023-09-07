# Exercices JEE

## Partie A :

Réaliser 3 pages utilisant toutes Bootstrap, via l'utilisation de la directive include

## Partie B :

Réaliser une page permettant l'affichage d'un tableau mis en forme avec Bootstrap. Ce tableau devra contenir au moins 3 personnes différentes en incluant leur nom de famille, prénom et âge.

Le rendu du tableau se fera via le passage d'une collection de personne depuis le servlet vers la JSP.

## Partie C :

Réaliser une page contenant un formulaire d'au moins 4 champs, permettant l'ajout d'un élément. Ces informations devront être transmises au Servlet pour un affichage en console.

## Partie D :

Réaliser une application Web avec Jakarta EE permettant à un utilisateur de manipuler des entités de données. Votre site devra comporter: 

- Une page de formulaire permettant l'ajout et le visionnage des éléments de données (Chat, Voiture, Personne...)
- Une page de visionnage des détails de l'élément par passage vers une route de type /elements/details/id

Indice : Pour pouvoir mettre en commun des éléments entre plusieurs servlet sans utiliser de connexion en base de données, pensez à créer une variable statique de type collection dans laquelle les servlet iront puiser pour accéder aux données. Par exemple : une classe FakeDB comprennant une variable statique de type ArrayList<T>