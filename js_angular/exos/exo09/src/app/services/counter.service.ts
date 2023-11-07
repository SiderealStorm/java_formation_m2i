import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CounterService {

  constructor() { }

  // Ajout correction : généralisation de la méthode
  count(maxValue: number = 100) {
    return new Observable<number>(sub => {
      let count = 1;
      setInterval(() => {
        if (count > maxValue) {
          sub.complete();
        }
        sub.next(count++);
      }, 1000);
    })
  }

  getLetter() {
    return this.count(26).pipe(map(value => String.fromCharCode(64 + value)))
  }
}
