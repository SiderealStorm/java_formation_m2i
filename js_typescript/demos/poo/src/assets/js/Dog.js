import Mammal from "./Mammal.js";
// Déclaration de classe avec héritage
class Dog extends Mammal {
    // Déclaration et instanciation d'un attribut statique
    static count = 0;
    // Déclaration des champs (obligatoire en TS)
    _id;
    _breed;
    // Constructeur : doit prendre en compte tous les champs privés
    constructor(name, breed, age) {
        super(name, age);
        this._id = ++Dog.count;
        this._breed = breed;
    }
    // Getters et setters
    get name() {
        return this._name;
    }
    get id() {
        return this._id;
    }
    set name(name) {
        this._name = name;
    }
}
export default Dog;
