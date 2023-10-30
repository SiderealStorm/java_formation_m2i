import { Component } from '@angular/core';

@Component({
  selector: 'app-form-user',
  templateUrl: './form-user.component.html',
  styleUrls: ['./form-user.component.css']
})
export class FormUserComponent {
  firstName = "";
  lastName = "";
  age = 0;

  onChangeFirstName(event: Event) {
    this.firstName = (event.target as HTMLInputElement).value;
  }
  
  onChangeLastName(event: Event) {
    this.lastName = (event.target as HTMLInputElement).value;
  }
  
  onChangeAge(event: Event) {
    this.age = parseInt((event.target as HTMLInputElement).value);
  }

  onSubmitForm(event: Event) {
    event.preventDefault();
    const newUser = {
      firstName: this.firstName,
      lastName: this.lastName,
      age: this.age
    }

    this.firstName = "";
    this.lastName = "";
    this.age = 0;

    console.log(newUser);
  }
}
