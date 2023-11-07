import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {

  @Output() closeModalEvent = new EventEmitter();

  onClickClose(event: Event | undefined = undefined) {
    if (event) {
      if (event.currentTarget === event.target) {
        this.closeModalEvent.emit();
      }
    } else {
      this.closeModalEvent.emit();
    }
  }
}
