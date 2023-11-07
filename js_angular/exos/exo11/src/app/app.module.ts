import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FizzBuzzPipe } from './pipes/fizz-buzz.pipe';
import { FizzBuzzDisplayComponent } from './components/fizz-buzz-display/fizz-buzz-display.component';

@NgModule({
  declarations: [
    AppComponent,
    FizzBuzzPipe,
    FizzBuzzDisplayComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
