import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-styles';
  maValeur = "";

  getStyle() {
    return {
      'color': this.maValeur === 'toto' ? 'green' : 'black'
    }
  }
}
