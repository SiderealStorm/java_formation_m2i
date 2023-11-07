import { Component, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { CounterService } from 'src/app/services/counter.service';

@Component({
  selector: 'app-fizz-buzz-display',
  templateUrl: './fizz-buzz-display.component.html',
  styleUrls: ['./fizz-buzz-display.component.css']
})
export class FizzBuzzDisplayComponent implements OnDestroy {
  
  countValue = 0;
  countSub: Subscription | undefined;

  constructor(private service: CounterService) {
    this.countSub = this.service.count$.subscribe(value => this.countValue = value);
  }

  ngOnDestroy(): void {
    this.countSub?.unsubscribe();
  }
}
