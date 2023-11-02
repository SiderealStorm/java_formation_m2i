import { Component } from '@angular/core';

@Component({
  selector: 'app-other',
  templateUrl: './other.component.html',
  styleUrls: ['./other.component.css']
})
export class OtherComponent {

  firstNames = ["zaCk", "eLliE", "BEN", "storm", "henDrIK", "rOMie"];

  today = new Date();
}
