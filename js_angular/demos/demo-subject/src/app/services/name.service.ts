import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NameService {

  // Les Subjects sont un dérivé d'observables ; il faut préciser le type de l'élément
  // Un Subject fonctionne un peu comme un EventEmitter dans son fonctionnement
  // Par convention, tout objet de type évennementiel commence par $
  $names = new BehaviorSubject<string[]>(["Joe", "Jack", "Jane", "Jill"]);

  constructor() { }

  addName(newName : string) {
    this.$names.next([...this.$names.getValue(), newName]);
  }
}
