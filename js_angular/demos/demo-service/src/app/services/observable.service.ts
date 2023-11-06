import { Injectable } from '@angular/core';
// Import pour l'observable via rxjs
import { Observable, map } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class ObservableService {

  constructor() { }

  // Un observable est créé via une méthode qui le retourne
  countdown() {
    // La méthode retourne l'observable avec sa logique
    // L'observable utilise les génériques, son retour doit être typé
    return new Observable<number>(subscriber => {
      let count = 10;

      setInterval(() => {
        if (count === 0) {
          subscriber.complete();
        }
        // if (count === 2) {
        //   // Par défaut, la levée d'une erreur termine l'observable !
        //   subscriber.error("Bad number !")
        // }
        subscriber.next(--count);
      }, 1000);
    })
  }

  // On peut appliquer un pipe à un observable afin de modifier le comportement de l'observable
  getRound() {
    return this.countdown().pipe(
      // On utilise différents fonctions appelées opérateurs
      map(data => {
        // l'opérateur map permet de modifier les données reçues de l'observable
        return `Round n°${data}`;
      })
    )
  }
}
