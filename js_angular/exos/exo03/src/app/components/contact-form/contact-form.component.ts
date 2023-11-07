import { Component, EventEmitter, Output } from '@angular/core';
import { Contact } from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {
  contact : Contact = new Contact("", "", 0, "", "");
  
  @Output()
  eventItem = new EventEmitter<Contact>();

  onSubmitForm(event : Event) {
    event.preventDefault();
    const newContact = new Contact(
      this.contact.firstName,
      this.contact.lastName,
      this.contact.age,
      this.contact.mail,
      this.contact.phone
    )
    this.eventItem.emit(newContact);
  }
}
