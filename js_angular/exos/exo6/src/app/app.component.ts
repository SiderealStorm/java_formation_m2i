import { Component, Input } from '@angular/core';
import { Contact } from './models/Contact.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'exo6';

  contactList : Contact[] = [
    new Contact("Marie", "Leroux", new Date("1986-02-16"), "m.leroux@mail.com", "0329947988"),
    new Contact("Jacques", "Moulins", new Date("1984-12-06"), "j.dupont@mail.com", "0321456987"),
    new Contact("Elie", "Dupont", new Date("1996-08-22"), "moulins.e@mail.com", "0326548989")
  ];
  
  addNewContact(contact : Contact) {
    this.contactList = [...this.contactList, contact];
  }

  deleteContact(id : number) {
    this.contactList = this.contactList.filter(contact => contact.id !== id);
  }
}
