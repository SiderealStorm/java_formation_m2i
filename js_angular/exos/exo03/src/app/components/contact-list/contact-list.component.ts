import { Component } from '@angular/core';
import { Contact } from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent {
  contactsList : Contact[] = [];

  saveNewContact(contact : Contact) {
    this.contactsList.push(contact)
  }

  onClickDelete(contact : Contact) {
    this.contactsList = this.contactsList.filter(c => c.id !== contact.id);
  }
}
