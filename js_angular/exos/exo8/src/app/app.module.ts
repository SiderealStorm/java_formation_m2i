import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TimerDisplayComponent } from './components/timer-display/timer-display.component';
import { TimerFormComponent } from './components/timer-form/timer-form.component';

@NgModule({
  declarations: [
    AppComponent,
    TimerDisplayComponent,
    TimerFormComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
