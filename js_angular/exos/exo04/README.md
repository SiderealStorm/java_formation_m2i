# Exercice Angular E

Réaliser une application Angular permettant d'obtenir un affichage sous la forme de cartes "à la Bootstrap" d'entités de données:
- Ces entités seront ajoutées via un composant dédié à la gestion de l'ajout (un formulaire).
- Dans les cartes, vous aurez à la fois les détails de notre élément de données ainsi qu'un bouton, qui sera contenu un autre composant enfant.
- L'appui sur le bouton devra causer la suppression de l'élément de données de notre listing. 

Au niveau de la hiérarchie des composants, vous devez donc avoir une parenté telle que:
- AppComponent
    - ElementForm
    - ElementListing
        - DeleteButton