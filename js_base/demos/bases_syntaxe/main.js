// Affichage console

// Faire un affichage console :
console.log("Hello World");


// Affichage dans la page Web

// // Message pop-up :
// alert("Bonjour");

// // Choix booléen :
// let maValeur = confirm("Êtes vous sûr ?");
// alert("Vous avez choisi " + maValeur);

// // Entrée textuelle :
// let monPrenom = prompt("Quel est votre prénom ?");
// alert("Bonjour " + monPrenom + " !");


// Déclaration de variable

// Ancienne syntaxe :
var maVariable = 25;

// Syntaxe à utiliser :
let maVariable2 = 50;

// Constante :
const MA_CONSTANTE = 33;

// Les variables peuvent changer de type :
maVariable = "Blabla";

// Pour afficher le type d'une variable :
console.log(typeof monPrenom);


// Opérateurs

let nbA = 12;
let nbB = 5;

// Calculs :
console.log(nbA + nbB);
console.log(nbA - nbB);
console.log(nbA * nbB);
console.log(nbA / nbB);
console.log(nbA % nbB);
console.log(nbA ** nbB);    // Puissance

// Comparaisons (renvoie un booléen) :
console.log(nbA < nbB);
console.log(nbA > nbB);
console.log(nbA <= nbB);
console.log(nbA >= nbB);
console.log(nbA == nbB);
console.log(nbA != nbB);

// Deux types d'égalités/différences :
console.log(25 == "25");    // Sans typage
console.log(25 === "25");   // Avec typage

// Logiques :
console.log(nbA > nbB && "toto" == "titi");     // ET
console.log(nbA > nbB || "toto" == "titi");     // OU
console.log(!(nbA > nbB))      // NOT

// Ternaire :
let age = 29;
let texte = age >= 18 ? "OUI" : "NON";

console.log("Êtes-vous majeur ? " + texte);

// Null coarsing operator --> permet de définir des valeurs par défaut :
let variable = null;
let resultat = variable ?? "La variable est nulle";

console.log(resultat);

// Pour éviter les erreurs en cas de valeur "undefined" :
let monTexte;

console.log(monTexte?.toUpperCase());


// Structures de contrôle

// Si... sinon :
let unAge = 25;

if (unAge >= 21) {
    console.log("Il est majeur aux USA et en France");
} else if (unAge >= 18) {
    console.log("Il est majeur en France");
} else {
    console.log("Il est mineur");
}

// Switch case :
let uneReponse = "D";

switch (uneReponse) {
    case "A" :
        console.log("Vous avez choisi la réponse A");
        break;
    case "B" :
        console.log("Vous avez choisi la réponse B");
        break;
    case "C" :
        console.log("Vous avez choisi la réponse C");
        break;
    case "D" :
        console.log("Vous avez choisi la réponse D");
        break;
}

// Do/While :
let nom = "";

do {
    nom = prompt("Veuillez entrer votre nom :")
} while (nom == "");

let unNombre = 0;

while (unNombre <= 0) {
    unNombre = prompt("Veuillez entrer un nombre positif");
}

// Boucle for :
for (let i = 1 ; i <= 5 ; i++) {
    console.log("Itération n°" + i);
}

// Boucles d'affichage : permettent uniquement la lecture des valeurs, pas leur modification !

// Boucle for of sur un itérable (~ for each) :
const ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

for (const lettre of ALPHABET) {
    console.log(lettre);
}


// Tableaux (Array)

// Création :
let monTableau = [1, 2, "Test", true, ["A", "B"], 18];

// Affichage :
console.log(monTableau);

for (const element of monTableau) {
    console.log(element);
}

// Ajout en fin d'array :
monTableau.push("ajout à la fin");

// Ajout en début d'array :
monTableau.unshift("ajout au début");

console.log(monTableau);

// Suppression à la fin :
monTableau.pop();

// Suppression au début :
monTableau.shift();

console.log(monTableau);

// Spread operator = récupère les éléments d'un tableau :
let tabA = [1, 2, 3];
let tabB = [4, 5, 6];

let tabAetB = [tabA, tabB];     // On obtient une matrice des deux tableaux
let tabAplusB = [...tabA, ...tabB];     // On obtient un tableau des éléments des deux tableaux

console.log(tabAetB);
console.log(tabAplusB);

let tabSuite = [...tabAplusB, 7, 8, 9];
console.log(tabSuite);

let [elt1, elt2, ...reste] = tabSuite;
console.log(elt1);
console.log(elt2);
console.log(reste);

// Inversion de variables via constructing / deconstructing
let varA = 25;
let varB = 12;

console.log("A = " + varA);
console.log("B = " + varB);

[varA, varB] = [varB, varA];

console.log("A = " + varA);
console.log("B = " + varB);


// Fonctions

function sansParam() {
    console.log("Appel de la fonction sans paramètres");
}

sansParam();

function sansRetour(param) {
    console.log("param = " + param);
}

sansRetour("Test");

function addition(nbA, nbB) {
    return nbA + nbB;
}

console.log(addition(1, 3));

console.log(addition("Test", 25));

// On peut tout stocker en variable, MÊME des fonctions !
let maFonctionAddition = addition;

console.log(maFonctionAddition(5, 8));

// Fonction créée en tant que constante :
const maFonctionMutliplier = function (a, b) {
    return a * b;
}

console.log(maFonctionMutliplier(2, 4));

// => On passe par une fonction fléchée :
const maFonctionFlechee = (a, b) => {
    console.log("Je passe par ma fonction fléchée");
    return a * b;
}

console.log(maFonctionFlechee(2, 4));

// Simplification si fonction simple (une ligne)
const maFonctionOneline = (a, b) => a * b;

console.log(maFonctionOneline(2, 4));


// Les fonctions fléchées sont très utilisées en JS :
const prenoms = ["Chloé", "Bernard", "Danielle", "Albert"];

console.log(prenoms.find((prenom) => prenom.startsWith("B")));

// On peut passer une fonction en paramètre d'une fonction (= callback) :
function monOperation(a, b, operation) {
    console.log("Je vais une opération");
    return operation(a, b);
}

console.log(monOperation(2, 4, (a, b) => a + b));


// Méthodes "statiques"

console.log(Math.ceil(Math.random() * 10));