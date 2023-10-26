import Dog from "./Dog.js";
import Cat from "./Cat.js";

// Instanciation d'objets
const bernie = new Dog("Bernie", "Labrador", 8);
const max = new Dog("Max", "Doberman", 5);

console.log(bernie);
console.log(max);

const poupette = new Cat("Poupette", 8, false);

console.log(poupette);

// Utilisation des getters/setters

console.log(poupette.name);

bernie.age = 9;
console.log(bernie);
