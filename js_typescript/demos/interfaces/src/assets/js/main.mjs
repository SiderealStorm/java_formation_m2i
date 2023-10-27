// Interfaces TS =/= interfaces Java !!!
const unObjet = {
    firstname: "John",
    lastname: "Dupont"
};
// Les interfaces TS forcent l'implémentation des CHAMPS
class PersonClass {
    constructor(firstname, lastname, email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
}
const unePersonne = new PersonClass("Maria", "Dubois", "mdubois@mail.fr");
const uneAutrePersonne = new PersonClass("Jack", "Doe", "jdoe@mail.com");
// Fonction pour gérer des éléments de type différents mais avec des choses en commun
function gereDesPersonnes(element) {
    console.log(element.firstname);
    return element;
}
// Idem avec un générique
function gereDesElements(element) {
    console.log(element.firstname);
    return element;
}
const monRetour = gereDesElements(unObjet);
const monAutreRetour = gereDesElements(unePersonne);
// On n'a pas le même type retour selon la fonction utilisée :
// en utilisant un générique, on retourne l'objet tel qu'il est
// en utilisant l'interface, on retourne l'objet du type de l'interface
const retourPersonne = gereDesElements(uneAutrePersonne);
const retourPersonneInterface = gereDesPersonnes(uneAutrePersonne);
retourPersonne.email;
retourPersonneInterface.lastname;
// Le paramètre age n'est pas forcément peuplé
const unChien = {
    name: "Bernie",
    breed: "Labrador"
};
// mais il reste accessible
console.log("Age de mon chien : " + unChien.age);
const uneHashMap = {
    "titi": {
        firstname: "Titi",
        lastname: "Dupont"
    },
    "toto": {
        firstname: "Toto",
        lastname: "Dupont"
    }
};
const monElement = uneHashMap["titi"];
export {};
