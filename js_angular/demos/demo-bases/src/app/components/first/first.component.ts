import { Component, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent {
  monTexte = "Je suis la valeur du texte";
  monImageUrl = "https://www.lintbells.com/cdn/shop/files/Dog_256x256_f261be5c-844d-49f0-967e-1212d5c0ce42_1400x.webp?v=1659622764";

  sayHello() {
    console.log("Hello world!")
  }

  logText(event: Event) {
    const valeurInput = (event.target as HTMLInputElement).value;

    console.log(valeurInput);
  }
}
