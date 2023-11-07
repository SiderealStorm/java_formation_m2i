import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CounterService {

  count$ = new BehaviorSubject<number>(0);

  constructor() { }

  changeCountValue(value: number) {
    this.count$.next(this.count$.getValue() + value);
  }
}
