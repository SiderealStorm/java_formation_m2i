import { Component, EventEmitter, Input, OnDestroy, OnInit, Output, ViewChild } from '@angular/core';

@Component({
  selector: 'app-timer-display',
  templateUrl: './timer-display.component.html',
  styleUrls: ['./timer-display.component.css']
})
export class TimerDisplayComponent implements OnInit, OnDestroy {

  @Input({
    required: true
  })
  currentTime !: number;

  @Output()
  deleteTimerEvent = new EventEmitter();

  hours = 0;
  minutes = 0;
  seconds = 0;

  interval: number | undefined;

  ngOnInit(): void {
    this.countdown();
  }
  
  ngOnDestroy(): void {
    if (this.interval) {
      clearInterval(this.interval)
    }
  }

  countdown() {
    this.hours = Math.floor(this.currentTime / 3600);

    this.minutes = Math.floor((this.currentTime - this.hours * 3600) / 60);

    this.seconds = Math.floor(this.currentTime -this.hours * 3600 - this.minutes * 60);

    this.interval = window.setInterval(() => {
      if (this.currentTime > 0) {
        this.currentTime--;
        this.hours = Math.floor(this.currentTime / 3600);

        this.minutes = Math.floor((this.currentTime - this.hours * 3600) / 60);

        this.seconds = Math.floor(this.currentTime -this.hours * 3600 - this.minutes * 60);
      }
    }, 1000);
  }

  onDeleteTimer() {
    this.deleteTimerEvent.emit()
  }
}
