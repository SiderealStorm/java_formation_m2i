// Importation des classes depuis d'autres fichiers
// // En cas d'import multiple, il faut préciser le nom de la classe à importer :
// import { Person as Blabla } from "./Person";      // On peut donner un alias à la classe
// En cas d'import par défaut, on donne juste un alias à la classe importée :
import Person from "./Person.js";


// Récupérer le contenu d'une balise :
const mainH1 = document.querySelector("main > h1").textContent;

console.log(mainH1);

// Récupérer une balise avec son ID :
const monParagraphe = document.querySelector("p#un-id");

// Modifier le contenu d'une balise :
monParagraphe.textContent = "Blablabla";


// Programmation évènementielle

const monBouton = document.querySelector("button");

// Pour exécuter un script en fonction d'un évènement du DOM,
// il faut passer par un "écouteur" d'évènements :
monBouton.addEventListener("click", () => {
    console.log("Bonjour tout le monde !");
})

const maListe = document.querySelector("#ma-liste");

let compteur = 1;

// Ajouter un élément dynamiquement :
monBouton.addEventListener("click", () => {
    const index = compteur++;
    const unLi = document.createElement("li");
    unLi.textContent = `Element n°${index}`;
    // On peut ajouter un écouteur d'évènements sur les éléments ajoutés :
    unLi.addEventListener("click", () => {
        console.log("On a cliqué sur l'élément n°" + index);
    })
    maListe.appendChild(unLi);
})

//
const monForm = document.querySelector("form");


// L'évènement provoqué par le navigateur est récupérable en mettant un argument à la méthode
monForm.addEventListener("submit", (event) => {
    // Pour empêcher le comportement par défaut de l'évènement :
    event.preventDefault();
    console.log(event);
    const personne = new Person(
        document.querySelector("input#firstname").value,
        document.querySelector("input#lastname").value
    );
    console.log(personne);
});

// "Ecouter" la modification d'un champ :
const firstnameInput = document.querySelector("input#firstname");

firstnameInput.addEventListener("input", (event) => {
    console.log(event.target.value);
});