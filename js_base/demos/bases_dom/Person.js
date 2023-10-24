// Création d'une classe dans un autre fichier

class Person {
    constructor(firstname, lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

// Autre classe pour l'exemple :
class AutreClasse {
    constructor(titi, toto) {
        this.titi = titi;
        this.toto = toto;
    }
}

// Exportation des classes

// // Exportation de chaque classe :
// export { Person, AutreClasse }

// Exportation par défaut :
export default Person;