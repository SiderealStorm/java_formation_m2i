import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NameButtonComponent } from './components/name-button/name-button.component';
import { NamesListComponent } from './components/names-list/names-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NameButtonComponent,
    NamesListComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
