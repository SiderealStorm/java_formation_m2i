import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GenerateLetterService {

  constructor() { }

  counter() {
    return new Observable<number>(sub => {
      let count = 1;
      setInterval(() => {
        if (count > 26) {
          sub.complete();
        }
        sub.next(count++);
      }, 1000);
    })
  }

  getLetter() {
    return this.counter().pipe(map(value => String.fromCharCode(64 + value)))
  }
}
