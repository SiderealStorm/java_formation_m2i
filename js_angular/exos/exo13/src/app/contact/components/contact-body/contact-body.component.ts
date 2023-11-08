import { Component } from '@angular/core';

@Component({
  selector: 'app-contact-body',
  templateUrl: './contact-body.component.html',
  styleUrls: ['./contact-body.component.css']
})
export class ContactBodyComponent {
  contacts = ["Ellie", "Zack", "Charlie", "Hendrik", "Romie"];
}
