# Exercice 6 (Spring Security)

Réaliser une application Web permettant, de façon sécurisée, de modifier des entités de données (au choix).

- La visualisation des données devra être publique (/dogs, /dogs/1, ...)
- La modification des données devra être privée et demandera à un utilisateur d'être connecté (/dogs/add, /dog/delete/1, /dogs/edit/1, ...)

Les données se trouverons stockées en base de données via l'utilisation de PostgreSQL.

Vous utiliserez une sécurisation via le mécanisme de session de sorte à stocker en cookies votre état de sécurité. 