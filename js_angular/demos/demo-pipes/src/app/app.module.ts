import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { OtherComponent } from './components/other/other.component';
import { ToCapitalizePipe } from './pipes/to-capitalize.pipe';

@NgModule({
  declarations: [
    AppComponent,
    OtherComponent,
    ToCapitalizePipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
