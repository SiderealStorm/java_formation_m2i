import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-communication';
  maVariable = "Texte du parent";

  changeMaVariable() {
    this.maVariable = "Texte modifié";
  }
  
  customiserMaVariable(texte : string) {
    this.maVariable = texte;
  }
}
