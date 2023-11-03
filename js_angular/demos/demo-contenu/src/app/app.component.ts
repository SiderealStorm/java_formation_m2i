import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-contenu';

  onClickA() {
    console.log("Clic sur le bouton A");
  }

  onClickB() {
    console.log("Clic sur le bouton B");
  }
}