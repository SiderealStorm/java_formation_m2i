import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FizzBuzzService {

  count$ = new BehaviorSubject<number>(0);

  constructor() { }

  changeCountValue(value: number) {
    this.count$.next(value);
  }
}
