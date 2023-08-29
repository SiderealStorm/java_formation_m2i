## Exercice 6 TDD Avec Mock :  *Pendu*

Le but de l'exercice est de développer un programme pour émuler le jeu du pendu.

Le jeu a une classe LePendu, qui possède:

- Une méthode pour générer un masque : cette méthode fait appel à un objet qui permet de générer de façon aléatoire un mot à trouver à partir d'un tableau de mots.
- Une méthode pour tester si un char est dans le mot : si la lettre est dans le mot, le masque est modifié, sinon le joueur perd une vie.
- Une méthode pour tester si le joueur a gagné.