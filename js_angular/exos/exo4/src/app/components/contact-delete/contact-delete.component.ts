import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Contact } from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-delete',
  templateUrl: './contact-delete.component.html',
  styleUrls: ['./contact-delete.component.css']
})
export class ContactDeleteComponent {

  @Input({
    required: true
  })
  contact !: Contact;

  @Output()
  deleteContactEvent = new EventEmitter<Contact>();

  onClickDelete() {
    this.deleteContactEvent.emit(this.contact);
  }
}
