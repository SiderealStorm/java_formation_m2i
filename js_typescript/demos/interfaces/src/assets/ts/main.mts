// Interfaces TS =/= interfaces Java !!!

interface PersonInterface {
    firstname : string;
    lastname : string;
}

const unObjet : PersonInterface = {
    firstname: "John",
    lastname: "Dupont"
}

// Les interfaces TS forcent l'implémentation des CHAMPS
class PersonClass implements PersonInterface {
    firstname: string;
    lastname: string;
    email : string

    constructor (firstname : string, lastname : string, email : string) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
}

const unePersonne : PersonInterface = new PersonClass("Maria", "Dubois", "mdubois@mail.fr");
const uneAutrePersonne : PersonClass = new PersonClass("Jack", "Doe", "jdoe@mail.com");

// Fonction pour gérer des éléments de type différents mais avec des choses en commun
function gereDesPersonnes(element : PersonInterface) {
    console.log(element.firstname);
    return element;
}


// Idem avec un générique
function gereDesElements<T extends PersonInterface> (element : T) {
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

// Paramètres optionnels
type animal = {
    name : string;
    breed : string;
    // age sera number ou undefined
    age ?: number;
}

// Le paramètre age n'est pas forcément peuplé
const unChien : animal = {
    name : "Bernie",
    breed : "Labrador"
}

// mais il reste accessible
console.log("Age de mon chien : " + unChien.age);

// On peut créer des types personnalisés à partir d'une classe :
// Tous les champs requis de l'animal
type animalChampsObligatoires = Required<animal>;
// animal avec uniquement les champs obligatoires
type animalAvecChampsOptionnels = Partial<animal>
// animal sans race ni âge
type animalSansRaceNiage = Omit<animal, "breed" | "age">


// Typer une hashmap

type UnRecord = Record<string, {
    firstname : string;
    lastname : string
}>

const uneHashMap : UnRecord = {
    "titi" : {
        firstname: "Titi",
        lastname: "Dupont"
    },
    "toto": {
        firstname: "Toto",
        lastname: "Dupont"
    }
}

const monElement = uneHashMap["titi"];