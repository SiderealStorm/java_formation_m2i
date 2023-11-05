import { Component, ElementRef, EventEmitter, ViewChild, Output } from '@angular/core';
import { Timer } from 'src/app/models/Timer.model';

@Component({
  selector: 'app-timer-form',
  templateUrl: './timer-form.component.html',
  styleUrls: ['./timer-form.component.css']
})
export class TimerFormComponent {
  
  @ViewChild('hours')
  hoursRef!: ElementRef<HTMLInputElement>;

  @ViewChild('minutes')
  minutesRef!: ElementRef<HTMLInputElement>;

  @ViewChild('seconds')
  secondsRef!: ElementRef<HTMLInputElement>;

  @Output()
  submitTimeEvent = new EventEmitter<number>();


  onSubmitTimerForm(event : Event) {
    event.preventDefault();

    const newTimer : Timer = {
      hours: this.hoursRef.nativeElement.value,
      minutes : this.minutesRef.nativeElement.value,
      seconds : this.secondsRef.nativeElement.value
    }
        
    const timeValue = this.convertTimerToSeconds(newTimer);
    
    this.submitTimeEvent.emit(timeValue);
  }

  convertTimerToSeconds(timer : Timer) {
    if (timer.hours || timer.minutes || timer.seconds) {
      return +timer.hours * 3600 + +timer.minutes * 60 + +timer.seconds;
    } else {
      return 0;
    }
  }
}
