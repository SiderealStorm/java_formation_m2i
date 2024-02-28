# Exercice Hibernate

## Partie 1 :

En utilisant hibernate, créer une entité produit avec les caractéristiques suivantes:
- id: int, généré automatiquement
- marque: string
- reference: string
- dateAchat: date
- prix: double
- stock: int

Dans une classe Test (ou le Main) :
- Créer cinq produits,
- Afficher les informations du produit dont id = 2,
- Supprimer le produit dont id = 3,
- Modifier les informations du produit dont id = 1,

## Partie 2 :
Ajouter à notre application les fonctionnalités suivantes :

1. Afficher la totalité des produits 
2. Afficher la liste des produits dont le prix est supérieur à 100 euros 
3. Afficher la liste des produits achetés entre deux dates.

## Partie 3 :
Modifier l'application en ajoutant les fonctionnalités suivantes:

1. Afficher la liste des produits commandés entre deux dates lus au clavier.
2. Retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.

## Partie 4 :

Modifier l'application en ajoutant les fonctionnalités suivantes:

1. Afficher la valeur du stock des produits d'une marque choisie.
2. Calculer le prix moyen des produits.
3. Récupérer la liste des produits d'une marque choisie.
4. Supprimer les produits d'une marque choisie de la table produit.

## Partie 5 :

On souhaite modifier notre application en ajoutant les fonctionnalités suivantes :

* Chaque produit possède une ou plusieurs images (une image est caractérisée par un id et un url)
* Chaque produit possède un ou plusieurs commentaires (un id, un contenu et une date, une note).

1. Ajouter les classes nécessaires.
2. Ajouter la possibilité d'ajouter une image à un produit.
3. Ajouter la possibilité d'ajouter un commentaire à un produit.
4. Afficher les produits ave une note de 4 ou plus.

## Partie 6 :

On souhaite modifier notre application en ajoutant la possiblité de créer une commande, chaque commande possède plusieurs produits (Une commande est caractériée par Id, produits, total, date de commande)

1. Ajouter la ou les classes néssaires.
2. Ajouter la possibilité de créer une commande avec un ou plusieurs produits.
3. Afficher la totalité des commandes.
4. Afficher uniquement les commandes du jour.

## Partie 7 :

On souhaite modifier notre application en ajoutant la fonctionnalité suivante :

1. Chaque commande possède une seule adresse livraison et une adresse de livraison ne peut avoir qu'une seule commande (ce n'est pas le cas des vrais application c'est uniquement 
pour l'exercice)
2. Chaque adresse possède un id, rue, ville, code postal.
