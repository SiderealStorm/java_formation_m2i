import { Component, EventEmitter, Output } from '@angular/core';
import { Contact } from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {
  newContact : Contact = new Contact("", "", 0, "", "");

  @Output()
  addContactEvent = new EventEmitter<Contact>();

  capitalize(text : string) {
    return text.substring(0, 1).toUpperCase() + text.substring(1);
  }

  onSubmitForm(event : Event) {
    event.preventDefault();
    
    this.addContactEvent.emit(new Contact(
      this.capitalize(this.newContact.firstName),
      this.capitalize(this.newContact.lastName),
      this.newContact.age,
      this.newContact.mail,
      this.newContact.phone
    ));
  }
}
