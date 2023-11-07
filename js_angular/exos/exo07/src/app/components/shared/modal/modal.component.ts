import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {

  @Input({
    required: true
  })
  isModalVisible !: boolean;

  @Output()
  closeModalEvent = new EventEmitter();

  // On met 'undefined' comme valeur par défaut pour ne pas avoir à passer un évènement si on a pas besoin
  onCloseModal(event : Event | undefined = undefined) {
    if (event) {
      // Condition pour vérifier qu'on clique bien sur un élément qui déclanche l'évènement,
      // mais pas un de ses enfants.
      if (event.target === event.currentTarget) {
        this.closeModalEvent.emit();
      }
    } else {
      this.closeModalEvent.emit();
    }
  }
}
