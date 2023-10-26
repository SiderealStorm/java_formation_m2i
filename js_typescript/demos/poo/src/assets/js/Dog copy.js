import Mammal from "./Mammal";
// Déclaration de classe avec héritage
class Dog extends Mammal {
    // Déclaration et instanciation d'un attribut statique
    static count = 0;
    // Déclaration des champs (obligatoire en TS)
    id;
    breed;
    // Constructeur : doit prendre en compte tous les champs privés
    constructor(name, breed, age) {
        super(name, age);
        this.id = ++Dog.count;
        this.breed = breed;
    }
}
export default Dog;
