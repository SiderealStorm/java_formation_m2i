# Exercice Angular D

Créer une application Angular possédant deux composants : 
- Un listing de personnes
- Un formulaire d'ajout de personnes

L'ajout de personnes sera provoqué par un bouton d'envoi de formulaire et enverra un signal à l'autre composant.
Ce signal contiendra le texte présent dans les champs du formulaire et, une fois réceptionné par l'autre composant, se verra ajouté à un listing de type `<tbody>`. 

Pour cela, il vous faudra, dans le parent, une variable de type **Array** et dans l'enfant un émetteur d'évènement de type **EventEmitter**