import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-pipes';

  firstNames = ["zaCk", "eLliE", "BEN", "storm", "henDrIK", "rOMie"];

  howMany = 5;

  toCapitalized(text : string) {
    return text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();
  }

  onClickDelete() {
    // // En utilisant un élément mutable, le programme ne voit pas la modification donc l'affichage n'est pas mis à jour !
    // // Ceci est dû au fait que les pipes sont "purs" par défaut
    // this.firstNames.pop();

    // On préfèrera créer un nouveau tableau pour que la valeur du tableau (= sa référence) change et déclancher le rerender
    this.firstNames = this.firstNames.slice(0, this.firstNames.length - 1);
  }
}
