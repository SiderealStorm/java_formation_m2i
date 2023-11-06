import { Component } from '@angular/core';
import { LogService } from 'src/app/services/log.service';
import { ObservableService } from 'src/app/services/observable.service';
import { map } from 'rxjs'

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent {

  valueObs = "";

  // Pour faire appel à un service, il faut l'instancier dans le constructeur
  // Ici on utilise la syntaxe raccourcie
  constructor(
    private service : LogService,
    private obsService : ObservableService
  ) {}

  onClickButton() {
    // On peut utiliser le service injecté pour déclancher ses méthodes
    this.service.sayHi("This is the first component");

    this.service.greetEveryone();

    // Appel de l'observable :
    // On peut appeler l'observable brut, ou celui avec un pipe
    this.obsService.getRound()
    // Pour récupérer les données, il faut s'abonner à l'observable et lui passer un objet de configuration
    .subscribe({
      // On définit quelles méthodes de l'observable on utilise et ce qu'elles doivent faire
      // Si on veut peupler les propriétés du composant via l'observable, il faut utiliser une fonction fléchée (référencement du this différent)
      next: (value) => {
        console.log(value);
        this.valueObs = value;
      },
      error (error) {
        console.log("Une errur est survenue :");
        console.log(error);
      }, 
      complete () {
        console.log("Observable terminé");
      }
    })
  }
}
