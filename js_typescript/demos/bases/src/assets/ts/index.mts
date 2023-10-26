// On importe les fichiers JS
import { sayHi } from "./other.js";

sayHi();

// Deux sortes de typage :
// Typage implicite (= par inférence) : fait automatiquement en fonction de la première valeur assignée
let maVariable = "Blabla";
const maConstante = 23;

console.log("Type de ma variable : " + typeof maVariable);
console.log("Type de ma constante : " + typeof maConstante);

// Typage explicite : fait par le programmeur
let maString: string;
maString = "23"

console.log("Type de ma string : " + typeof maString);

// Le typage permet d'avoir de l'auto-complétion

// Deux solutions si on veut pouvoir changer le type de la variable :
// - Utiliser any = l'élément peut être de n'importe quel type (pas propre en TS)
// - Assigner plusieurs types avec un pipe :
let monId: string | number = "23";
monId = 12;

// En TS, on peut créer des types avec le mot-clé type ;
// cela permet de facilement assigner les types multiples.

type MonType = string | number;

let unAutreId: MonType;

// On peut aussi récupérer le type d'un élément
let monTableau = [14, "Toto", true, 18];
type TypeDuTableau = typeof monTableau;
let monAutreTableau: TypeDuTableau = ["Tata", 25]

// L'assignation de types permet faire des tuples = "liste" avec une taille et un type défini
type MonTuple = [22, number, string, boolean];
let tableauTuple: MonTuple = [22, 31, "Storm", true];

// On peut aussi faire des pseudo-enums
type RaceDeChien = "Doberman" | "Berger Allemand" | "Beagle";
let raceDeMonChien: RaceDeChien = "Berger Allemand";

// Si on ne sait pas à l'avance si la variable sera instanciée
let variableInconnue: null | string = null;
// let variableInconnue: undefined | string;   // Autre solution mais moins propre

let resultat = false;

if (resultat) {
    variableInconnue = "Message"
}

console.log("Ma variable après résultat : " + variableInconnue);


// Si on veut utiliser une méthode sur une variable potentiellement nulle, on peut :
// * Faire un if() grâce aux TRUTHY values
// --> tout ce qui n'est pas null, undefined, false, 0 ou "" est considéré TRUTHY

if (variableInconnue) {
    console.log("Ma variable majuscule via if()" + variableInconnue.toUpperCase());
}

// Pour récupérer un booléen en fonction d'une variable via TRUTHY/FALSY :
const variableTruthy = !!variableInconnue;
console.log(variableTruthy);

// * Passer par le Optional Chaining Operator --> renvoie undefined si la variable est FALSY
console.log("Ma variable majuscule via ?. : " + variableInconnue?.toUpperCase());


// On peut dire à TS qu'on est sûr de pouvoir utiliser une méthode avec !.
// mais à utiliser avec précautions !

const desNombres = [1, 2, 3, 4, 5];
const unDeux = desNombres.find(n => n === 2);

// Utilisation avec une méthode :
console.log(unDeux!.toFixed(2))

// Utilisation das un résultat :
const unTrois = desNombres.find(n => n === 3)!;
console.log(unTrois.toFixed(2))


// Modification du HTML

// Les éléments HTML sont par défaut de type Element, ou null si pas trouvé
const monParagraphe = document.querySelector("p#mon-paragraphe")!;

monParagraphe.textContent = "Toto";

// Pour pouvoir utiliser certains éléments, il faut que TS connaisse son type précis
// Pour typer ET vérifier que l'élément existe, on utilise as Type :
const monInput = document.querySelector("input#mon-input") as HTMLInputElement;

console.log(monInput.value);


