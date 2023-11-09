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
  title !: string;

  @Output()
  closeEvent = new EventEmitter();

  onClickClose(event: Event | undefined = undefined) {
    if (event) {
      if (event.target === event.currentTarget) {
        this.closeEvent.emit();
      }
    } else {
      this.closeEvent.emit();
    }
  }

}
