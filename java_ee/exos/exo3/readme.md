# TP : CRUD liste de contacts

Réaliser une application permettant à des utilisateurs connectés d'accéder à un CRUD d'éléments personnalisés.

**Type d'éléments choisi : contacts**

- Chaque utilisateur doit avoir accès à son propre listing d'éléments et ne pas pouvoir intervenir sur les éléments des autres utilisateurs.
- Pour accéder au listing, à l'ajout, la suppression ou l'édition des éléments, il faudra également être connecté !
- Votre application devra contenir idéalement un total de 4 pages (La page d'accueil, la page de listing des éléments, le formulaire de manipulation des éléments et le formulaire de connexion / inscription). Pensez à utiliser les attributs pour provoquer un rendu conditionnel.
- Dans un soucis d'optimisation, les éléments seront gérés au moyen des DTO pour alléger au besoin les transferts de données entrantes dans le serveur. 
- Pour mettre en commun les informations, pensez à utiliser une classe possédant une ou plusieurs listes statiques pour permettre aux servlets d'accéder entre chaque requête aux mêmes données et d'en extraire les informations importantes pour la requête en cours.

## Bonus :
- Gestion des erreurs lors de la création de compte (pas de doublons d'emails, confirmation du mot de passe) et de la connexion, avec maintien des champs remplis par l'utilisateur
- Tri de la liste des contacts par ordre alphabétique (noms puis prénoms)
- Vérification du numéro de téléphone avec des patterns RexEx (*WIP*)
- Remplacement de l'adresse en String par un objet Address (*Non commencé*)