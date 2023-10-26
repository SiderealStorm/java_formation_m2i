import Mammal from "./Mammal.js";

// Déclaration de classe avec héritage
class Dog extends Mammal {
    // Déclaration et instanciation d'un attribut statique
    public static count = 0;

    // Déclaration des champs (obligatoire en TS)
    private _id : number;
    private _breed: string;

    // Constructeur : doit prendre en compte tous les champs privés
    constructor(name: string, breed: string, age: number) {
        super(name, age);
        this._id = ++Dog.count;
        this._breed = breed;
    }

    // Getters et setters
    
    public get name() : string {
        return this._name;
    }
    
    
    public get id() : number {
        return this._id;
    }
    
    
    public set name(name : string) {
        this._name = name;
    }
}

export default Dog;