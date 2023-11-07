import { Component, OnDestroy } from '@angular/core';
import { CounterService } from './services/counter.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy{

  countValue: number = 0;
  countSub: Subscription | undefined;

  constructor(private service: CounterService) {
    this.countSub = this.service.count$.subscribe(value => this.countValue = value);
  }

  ngOnDestroy(): void {
    this.countSub?.unsubscribe();
  }

  onClickChangeValue(value: number) {
    this.service.changeCountValue(value);
  }
}
