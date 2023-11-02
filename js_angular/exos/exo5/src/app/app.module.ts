import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ShortenTextPipe } from './pipes/to-short-text.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ShortenTextPipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
