import { Component, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { FizzBuzzService } from 'src/app/services/fizz-buzz.service';

@Component({
  selector: 'app-fizz-buzz-display',
  templateUrl: './fizz-buzz-display.component.html',
  styleUrls: ['./fizz-buzz-display.component.css']
})
export class FizzBuzzDisplayComponent implements OnDestroy {
  
  countValue = 0;
  countSub: Subscription | undefined;

  constructor(private service: FizzBuzzService) {
    this.countSub = this.service.count$.subscribe(value => this.countValue = value);
  }

  ngOnDestroy(): void {
    this.countSub?.unsubscribe();
  }
}
