# Exercice Angular A

Réaliser une application Angular permettant à un utilisateur, via un composant de type **form-user**, de taper son **prénom**, son **nom** et son **âge** dans un formulaire.
Suite à cela, l'envoi du formulaire devra provoquer en console l'affichage d'un objet anonyme en console.

Cet objet devra posséder la structure ci-dessous: 


```TypeScript
const newUser = {​
    firstname: "",
    lastname: "",
    age: 0
}​;

```


Attention à ne pas oublier de faire un event.preventDefault() sur l'envoi du formulaire de sorte à ne pas recharger notre page.