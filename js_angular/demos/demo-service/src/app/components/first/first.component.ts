import { Component } from '@angular/core';
import { LogService } from 'src/app/services/log.service';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent {

  // Pour faire appel à un service, il faut l'instancier dans le constructeur
  // Ici on utilise la syntaxe raccourcie
  constructor(private service : LogService) {}

  onClickButton() {
    this.service.sayHi("This is the first component");
  }
}
