import { Component, OnInit } from '@angular/core';
import { GenerateLetterService } from 'src/app/services/generate-letter.service';

@Component({
  selector: 'app-letter-display',
  templateUrl: './letter-display.component.html',
  styleUrls: ['./letter-display.component.css']
})
export class LetterDisplayComponent implements OnInit {

  letter = "";

  constructor(private service : GenerateLetterService) {}

  ngOnInit(): void {
    this.service.getLetter().subscribe({
      next : (value) => {
        this.letter = value;
      }
    });
  }

}
