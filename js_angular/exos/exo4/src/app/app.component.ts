import { Component } from '@angular/core';
import { Contact } from './models/Contact.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'exo4';

  contactList : Contact[] = [
    new Contact("John", "Doe", 27, "doe.john@mail.fr", "0321456987"),
    new Contact("Jane", "Doe", 27, "doe.jane@mail.fr", "0321456987"),
    new Contact("Jack", "Doe", 27, "doe.jack@mail.fr", "0321456987")
  ];

  addNewContact(contact : Contact) {
    this.contactList = [...this.contactList, contact];
  }

  deleteContact(contact : Contact) {
    this.contactList = this.contactList.filter(c => c.id !== contact.id);
  }
}
