import { Component } from '@angular/core';
import { FizzBuzzService } from './services/fizz-buzz.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  countValue: number = 0;
  countSub: Subscription | undefined;

  constructor(private service: FizzBuzzService) {
    this.countSub = this.service.count$.subscribe(value => this.countValue = value);
  }

  onClickChangeValue(value: number) {
    this.service.changeCountValue(value);
  }
}
