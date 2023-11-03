import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'exo8';

  timerList : number[] = [];

  getTimer(newTimer: number) {
    this.timerList = [...this.timerList, newTimer]
  }

  deleteTimer(index: number) {
    // Pour déclarer des paramètres qu'on n'utilise pas, on le précède d'un Underscore
    this.timerList = [...this.timerList.filter((_elt, i) => i !== index)]
  }
}
