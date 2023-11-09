import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact-body',
  templateUrl: './contact-body.component.html',
  styleUrls: ['./contact-body.component.css']
})
export class ContactBodyComponent {

  constructor(private router: Router) {}

  onClickNavigate() {
    this.router.navigate(['contacts', 'list']);
  }
}
