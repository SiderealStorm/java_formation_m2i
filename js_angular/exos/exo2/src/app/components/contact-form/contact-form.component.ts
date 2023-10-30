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
  firstName = "";
  lastName = "";
  age = 0;
  mail = "";
  phone = "";
  contactsList : Contact[] = [];

  onSubmitForm(event : Event) {
    event.preventDefault();

    let newContact : Contact = {
      firstName : this.firstName,
      lastName : this.lastName,
      age : this.age,
      mail : this.mail,
      phone : this.phone
    };

    this.contactsList.push(newContact);

    this.firstName = "";
    this.lastName = "";
    this.age = 0;
    this.mail = "";
    this.phone = "";
  }

  onClickDelete(contact : Contact) {
    const index = this.contactsList.indexOf(contact);
    if (index != -1) {
      this.contactsList.splice(index, 1);
    }
  }
}
