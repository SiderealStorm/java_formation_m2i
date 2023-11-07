import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Contact } from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent {

  @Input({
    required: true
  })
  contactList !: Contact[];

  filter : keyof Contact = "id";

  @Output()
  deleteContactEvent = new EventEmitter<number>();
  
  onClickDelete(contact : Contact) {
    this.deleteContactEvent.emit(contact.id);
  }
}
