import { Component, Output, EventEmitter } from '@angular/core';
import { Contact } from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {
  contact : Contact = new Contact ("", "", new Date(), "", "");

  @Output()
  addContactEvent = new EventEmitter<Contact>();

  onSubmitForm(event : Event) {
    event.preventDefault();
    
    this.addContactEvent.emit(new Contact(
      this.contact.firstName,
      this.contact.lastName,
      new Date(this.contact.birthDate),
      this.contact.mail,
      this.contact.phone
    ))
  }
}
