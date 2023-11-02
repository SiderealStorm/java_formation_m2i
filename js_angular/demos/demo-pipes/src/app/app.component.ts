import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-pipes';

  firstNames = ["zaCk", "eLliE", "BEN", "storm"];

  toCapitalized(text : string) {
    return text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();
  }
}
