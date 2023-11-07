# Exercice Angular L

Réaliser, via Angular, un compteur de FizzBuzz, dont voici les règles : 
- Pour un nombre multiple de 3, il sera écrit **Fizz**
- Pour un nombre multiple de 5, il sera écrit **Buzz**
- Pour un nombre multiple de 3 et de 5, il sera écrit **FizzBuzz**
- Pour tout autre nombre, il sera écrit la valeur du nombre

Pour cela, vous aurez plusieurs composants communiquant avec un service :
- FizzBuzzDisplayComponent: Sert à l'affichage du compteur en mode FizzBuzz
- FizzBuzzPipe: Sert à la transformation de la variable nombre en l'affichage selon les règles du FizzBuzz
- FizzBuzzService: Un service servant à la centralisation du compteur

Pour augmenter ou réduire la valeur du compteur, vous passerez par deux boutons dont l'attribut `disabled` sera conditionné.