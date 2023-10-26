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

// Ancienne syntaxe (à éviter) :
var maVariable = 25;

// Nouvelle syntaxe (à utiliser) :
let maVariable2 = 50;

// Constante (nom en majuscule par convention) :
const MA_CONSTANTE = 33;

// Les variables peuvent changer de type :
maVariable = "Blabla";

// Pour afficher le type (actuel) d'une variable :
console.log("Type de maVariable : " + typeof maVariable);


// Opérateurs

let nbA = 12;
let nbB = 5;

// Calculs :
console.log("Calculs avec" + nbA + " et " + nbB);
console.log(nbA + nbB);
console.log(nbA - nbB);
console.log(nbA * nbB);
console.log(nbA / nbB);
console.log(nbA % nbB);
console.log(nbA ** nbB);    // Puissance

// Comparaisons (renvoient un booléen) :
console.log("Comparaisons avec" + nbA + " et " + nbB);
console.log(nbA < nbB);
console.log(nbA > nbB);
console.log(nbA <= nbB);
console.log(nbA >= nbB);
console.log(nbA == nbB);
console.log(nbA != nbB);

// Deux types d'égalités/différences :
console.log("Egalités");
console.log(25 == "25");    // Sans typage
console.log(25 === "25");   // Avec typage

// Logiques :
console.log("Opérateurs logiques");
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

console.log("Résultat ternaire avec variable nulle :" + resultat);

// Si une variable est déclarée mais pas instanciée, elle vaut "undefined" :
let monTexte;
console.log("Texte non instancié = " + monTexte);

// Syntaxe variable?.methode() --> évite la levée d'erreurs en cas de variable "undefined" :
console.log("" + monTexte?.toUpperCase());


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
const CHRONO = "543210";

for (const chiffre of CHRONO) {
    console.log(chiffre);
}


// Tableaux (Array)

// Création :
let monTableau = [1, 2, "Test", true, ["A", "B"], 18];

// Affichage :
console.log("Tableau = " + monTableau);

for (const element of monTableau) {
    console.log("Elément du tableau : " + element);
}

// Ajout en fin d'array :
monTableau.push("ajout à la fin");

// Ajout en début d'array :
monTableau.unshift("ajout au début");

console.log("Tableau modifié = " + monTableau);

// Suppression à la fin :
monTableau.pop();

// Suppression au début :
monTableau.shift();

console.log("Tableau modifié = " + monTableau);

// Spread operator = récupère les éléments d'un tableau :
let tabA = [1, 2, 3];
let tabB = [4, 5, 6];

let tabAetB = [tabA, tabB];     // On obtient une matrice des deux tableaux
let tabAplusB = [...tabA, ...tabB];     // On obtient un tableau des éléments des deux tableaux

console.log("Tableau A et B = " + tabAetB);
console.log("Tableau A + B = " + tabAplusB);

let tabSuite = [...tabAplusB, 7, 8, 9];
console.log("Tableau avec la suite = " + tabSuite);

let [elt1, elt2, ...reste] = tabSuite;
console.log("Elément 1 : " + elt1);
console.log("Elément 2 : " + elt2);
console.log("Reste du tableau : " + reste);

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
    console.log("Appel de la fonction avec paramètres");
    console.log("param = " + param);
}

sansRetour("Test");

function addition(nbA, nbB) {
    console.log("Appel de la fonction addition");
    return nbA + nbB;
}

console.log(addition(1, 3));

console.log(addition("Test", 25));

// On peut tout stocker en variable, MÊME des fonctions !
let maFonctionAddition = addition;

console.log(maFonctionAddition(5, 8));

// Fonction créée en tant que constante :
const maFonctionMutliplier = function (a, b) {
    console.log("Appel de la fonction multiplier");
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

console.log("Fonction fléchée OneLine : " + maFonctionOneline(2, 4));


// Les fonctions fléchées sont très utilisées en JS :
const prenoms = ["Chloé", "Bernard", "Danielle", "Albert"];

console.log("Prénom commençant par B : " + prenoms.find((prenom) => prenom.startsWith("B")));

// On peut passer une fonction en paramètre d'une fonction (= callback) :
function monOperation(a, b, operation) {
    console.log("Je fais une opération");
    return operation(a, b);
}

console.log(monOperation(2, 4, (a, b) => a + b));


// Méthodes "statiques"

console.log("Nomre aléatoire avec Math : " + Math.ceil(Math.random() * 10));