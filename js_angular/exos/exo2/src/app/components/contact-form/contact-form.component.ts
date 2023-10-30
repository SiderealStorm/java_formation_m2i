import { Component } from '@angular/core';

type Contact = {
  firstName : string;
  lastName : string;
  age : number;
  mail : string;
  phone : string;
};

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {
  contact : Contact = {
    firstName : "",
    lastName : "",
    age : 0,
    mail : "",
    phone : "",
  }
  contactsList : Contact[] = [];

  onSubmitForm(event : Event) {
    event.preventDefault();

    this.contactsList.push(this.contact);

    this.contact = {
      firstName : "",
      lastName : "",
      age : 0,
      mail : "",
      phone : "",
    }
  }

  onClickDelete(contact : Contact) {
    this.contactsList = [... this.contactsList.filter(c => c !== contact)];
  }

  setRowStyle(contact: Contact) {
    return {
      'color': this.contactsList.indexOf(contact) % 2 !== 0 ? 'blue' : 'black'
    };
  }
  
  setAgeClass(contact: Contact) {
    return contact.age < 18 ? 'mineur' : '';
  }
}
