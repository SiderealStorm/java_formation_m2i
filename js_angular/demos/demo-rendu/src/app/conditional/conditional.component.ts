import { Component } from '@angular/core';

@Component({
  selector: 'app-conditional',
  templateUrl: './conditional.component.html',
  styleUrls: ['./conditional.component.css']
})
export class ConditionalComponent {
  age = 11;
  prenoms = ["Jaqcues", "Marie", "Eric", "Jeanne"];
  unPrenom = "";

  onIncrementAge() {
    this.age++;
    this.prenoms.push("Prénom " + this.age);
  }
}
