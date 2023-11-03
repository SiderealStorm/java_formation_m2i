import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-lifecycle';

  firstVisible = false;
  text = "";


  onSwitchVisibility() {
    this.firstVisible = !this.firstVisible;
  }

  // La méthode récupère l'élément HTML
  onChangeText(input: HTMLInputElement) {
    // On peut récupérer la valeur de la même façon qu'avec les éléments utilisés en JS
    this.text = input.value;
  }
}
