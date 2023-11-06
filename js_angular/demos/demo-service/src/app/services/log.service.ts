import { Injectable } from "@angular/core";
import { DataService } from "./data.service";

// Un service est une classe possédant des méthodes globales, 
// il est créé dans un dossier services et déclaré dans les providers du app.module
// Pour que ce service puisse utiliser d'autres services, il faut qu'il soit injectable
@Injectable({
    // Pour que le service soit injecté à la racine de l'application :
    providedIn: "root"
})
export class LogService {

    // On peut déclarer les services injectés comme dans un composant
    constructor(private dataService: DataService) {}

    sayHi(text : string) {
        console.log("Hello World !");
        console.log(text);
    }

    greetEveryone() {
        for (let person of this.dataService.names) {
            console.log("Hello " + person);
        }
    }
}