import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { FormAlbumComponent } from './components/album/form-album/form-album.component';
import { DisplayAlbumComponent } from './components/album/display-album/display-album.component';
import { ModalComponent } from './components/shared/modal/modal.component';
import { SortByPipe } from './pipes/sort-by.pipe';

@NgModule({
  declarations: [
    AppComponent,
    FormAlbumComponent,
    DisplayAlbumComponent,
    ModalComponent,
    SortByPipe
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
