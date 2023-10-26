// Déclaration d'une classe abstraite
class Mammal {
    static count = 0;
    // Déclaration des attributs en protected (= accessibles par les enfants)
    // Par convention, les champs non publics son notés _variable
    _name;
    _age;
    constructor(name, age) {
        this._name = name;
        this._age = age;
        ++Mammal.count;
    }
    // Getters et setters : par convention, portent le nom du champ (pas de get/set)
    // Getters
    get name() {
        return this._name;
    }
    get age() {
        return this._age;
    }
    // Setters
    set name(name) {
        this._name = name;
    }
    set age(age) {
        if (age > 0) {
            this._age = age;
        }
    }
}
export default Mammal;
