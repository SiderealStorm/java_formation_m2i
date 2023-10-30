import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoComponent } from './components/demo/demo.component';
import { DemoBisComponent } from './components/demo-bis/demo-bis.component';
import { DemoTerComponent } from './components/demo-ter/demo-ter.component';
import { FirstComponent } from './components/first/first.component';
import { SecondComponent } from './components/second/second.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    DemoBisComponent,
    DemoTerComponent,
    FirstComponent,
    SecondComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
