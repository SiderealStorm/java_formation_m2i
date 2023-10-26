import Mammal from "./Mammal.js";
class Cat extends Mammal {
    static count = 0;
    _id;
    _drinksMilk;
    constructor(name, age, drinksMilk) {
        super(name, age);
        this._id = ++Cat.count;
        this._drinksMilk = drinksMilk;
    }
    get id() {
        return this._id;
    }
    get drinksMilk() {
        return this._drinksMilk;
    }
    set drinksMilk(drinksMilk) {
        this._drinksMilk = drinksMilk;
    }
}
export default Cat;
