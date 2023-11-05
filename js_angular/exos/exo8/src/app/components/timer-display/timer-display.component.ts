import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { Timer } from 'src/app/models/Timer.model';

@Component({
  selector: 'app-timer-display',
  templateUrl: './timer-display.component.html',
  styleUrls: ['./timer-display.component.css']
})
export class TimerDisplayComponent implements OnInit, OnDestroy {

  @Input({
    required: true
  })
  startValue !: number;

  @Input({
    required: true
  })
  timerIndex !: number;

  @Output()
  deleteTimerEvent = new EventEmitter<number>();

  actualValue = 0;
  timer : Timer = {
    hours: "",
    minutes: "",
    seconds: ""
  };


  interval: number | undefined;

  ngOnInit(): void {
    this.actualValue = this.startValue;
    console.log("Temps reçu dant timer-display : " + this.startValue);
    this.timer = this.calculateTime(this.startValue);

    this.interval = window.setInterval(() => {
      if (this.actualValue > 0) {
        this.actualValue--;
        this.timer = this.calculateTime(this.actualValue);
      }  
    }, 1000);
  }

  ngOnDestroy(): void {
    clearInterval(this.interval);
  }


  onClickCancel() {
    this.actualValue = 0;
    this.timer = this.calculateTime(this.actualValue);
  }

  onClickDelete() {
    this.deleteTimerEvent.emit();
  }


  calculateTime(value : number): Timer {
    const hours = Math.floor(value / 3600);
    const minutes = Math.floor((value - hours * 3600) / 60);
    const seconds = Math.floor(value - hours * 3600 - minutes * 60);

    return {
      hours: hours.toString().padStart(2, "0"),
      minutes: minutes.toString().padStart(2, "0"),
      seconds: seconds.toString().padStart(2, "0"),
    }
  }
}
