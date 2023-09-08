# Exercice 2

Réaliser une application Jakarta EE permettant à des utilisateurs de s'enregistrer et/ou de se connecter pour accéder à un contenu privé. 

L'application proposera :
- Un servlet gérant les enregistrement via une méthode POST.
    - Cette méthode devra vérifier dans une fausse base de données si l'utilisateur est déjà existant de sorte à informer l'utilisateur que cet username/email n'est pas disponible le cas échéant.
    - Si l'ensemble n'est pas pré-existant, l'utilisateur se verra automatiquement connecté et visualisera une page secrète.
- Un servlet permettant de gérer la connexion.
Sa méthode POST devra vérifier si l'ensemble username/email et mot de passe est existant. Dans ce cas, l'utilisateur se verra connecté et accèdera directement à la page secrète.

La page secrète devra n'être accessible que par les utilisateurs connectés et redirigera les indésirables vers le formulaire de connexion.
Si la page est accessible, alors elle devra montrer un message de bienvenue spécifique à l'utilisateur (lui rappellant par exemple son nom ou son email)

Pour gérer les utilisateurs, pensez à réaliser une variable statique dans une classe de fausse base de données. Cette variable pourra ainsi être accessible à l'ensemble des servlets de votre application