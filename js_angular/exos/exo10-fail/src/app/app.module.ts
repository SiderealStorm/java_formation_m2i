import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AlbumFormComponent } from './components/album-form/album-form.component';
import { ModalComponent } from './components/shared/modal/modal.component';
import { AlbumCardComponent } from './components/album-card/album-card.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AlbumFormComponent,
    ModalComponent,
    AlbumCardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
