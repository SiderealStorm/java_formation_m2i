import { Component } from '@angular/core';
import { TimeObject } from './models/TimeObject.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  // Utilisation d'un objet car, si passe par un tableau de nombres, les éléments n'ont pas de référence propre ;
  // de ce fait, si un nombre est présent plusieurs fois, c'est toujours la dernière occurence qui sera supprimée, et pas forcément l'élément voulu
  timeList : TimeObject[] = [];

  addTimeToList(time : number) {
    this.timeList = [...this.timeList, new TimeObject(time)];
  }

  removeTimeFromList(index : number) {
    this.timeList = [...this.timeList.filter((time) => time.index !== index)];
  }
}
