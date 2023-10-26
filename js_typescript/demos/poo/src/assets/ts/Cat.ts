import Mammal from "./Mammal.js";

class Cat extends Mammal {
    public static count = 0;

    private _id : number;
    private _drinksMilk: boolean;

    constructor(name: string, age: number, drinksMilk: boolean) {
        super(name, age);
        this._id = ++Cat.count;
        this._drinksMilk = drinksMilk;
    }

    
    public get id() : number {
        return this._id;
    }
    
    public get drinksMilk() : boolean {
        return this._drinksMilk;
    }
    
    public set drinksMilk(drinksMilk : boolean) {
        this._drinksMilk = drinksMilk;
    }
    
}

export default Cat;