import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { OtherComponent } from './components/other/other.component';
import { ToCapitalizePipe } from './pipes/to-capitalize.pipe';
import { SliceArrayPipe } from './pipes/slice-array.pipe';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    OtherComponent,
    ToCapitalizePipe,
    SliceArrayPipe
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
