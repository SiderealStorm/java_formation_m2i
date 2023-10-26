// Déclaration d'une classe abstraite
abstract class Mammal {
    public static count = 0;

    // Déclaration des attributs en protected (= accessibles par les enfants)
    // Par convention, les champs non publics son notés _variable
    protected _name: string;
    protected _age : number;

    constructor(name: string, age: number) {
        this._name = name;
        this._age = age;
        ++Mammal.count;
    }

    // Getters et setters : par convention, portent le nom du champ (pas de get/set)

    // Getters
    public get name() : string {
        return this._name;
    }
    
    public get age() : number {
        return this._age;
    }

    // Setters
    public set name(name : string) {
        this._name = name;
    }
    
    public set age(age : number) {
        if (age > 0) {
            this._age = age;
        }
    }
}

export default Mammal;