import { Component, ViewChild, Output, EventEmitter, ElementRef } from '@angular/core';

@Component({
  selector: 'app-timer-form',
  templateUrl: './timer-form.component.html',
  styleUrls: ['./timer-form.component.css']
})
export class TimerFormComponent {

  @ViewChild("hours") hoursInputRef!: ElementRef<HTMLInputElement>;
  @ViewChild("minutes") minutesInputRef!: ElementRef<HTMLInputElement>;
  @ViewChild("seconds") secondsInputRef!: ElementRef<HTMLInputElement>;

  @Output() getTimeEvent = new EventEmitter<number>();

  onSubmitForm(event: Event) {
    event.preventDefault();

    const hours = parseInt(this.hoursInputRef.nativeElement.value);
    const minutes = parseInt(this.minutesInputRef.nativeElement.value);
    const seconds = parseInt(this.secondsInputRef.nativeElement.value);

    this.getTimeEvent.emit(seconds + minutes * 60 + hours * 3600);

    this.hoursInputRef.nativeElement.value = "0";
    this.minutesInputRef.nativeElement.value = "0";
    this.secondsInputRef.nativeElement.value = "0";
  }
}
