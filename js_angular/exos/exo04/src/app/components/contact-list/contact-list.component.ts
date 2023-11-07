import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Contact } from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent {
  
  @Input({
    required : true
  })
  contactList !: Contact[];

  @Output()
  deleteContactEvent = new EventEmitter<Contact>();

  deleteContact(contact : Contact) {
    this.deleteContactEvent.emit(contact);
  }
}
