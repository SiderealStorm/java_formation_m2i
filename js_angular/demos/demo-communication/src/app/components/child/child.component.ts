import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {
  maVariable = "Texte du composant";

  // Injecter une variable depuis le composant parent grâce à @Input()
  @Input({
    // On peut redéfinir le nom de la propriété
    alias: "varA",
    // On peut aussi définir si la variable doit être obligatoirement peuplée,
    // ce qui permet de provoquer une erreur de compilation si la variable n'est pas envoyée
    required: true
  })
  variableParent = "Valeur par défaut";

  // Envoyer une variable dans le composant parent grâce à @Output()
  @Output()
  // On doit envoyer un EventEmitter
  unEvenement = new EventEmitter();

  @Output()
  // Il est préférable de typer l'évènement émis
  unAutreEvenement = new EventEmitter<string>();

  faitQqchDansParent() {
    this.unEvenement.emit();
  }
  
  changerTexteParent(event : Event) {
    this.unAutreEvenement.emit((event.target as HTMLInputElement).value);
  }
}
