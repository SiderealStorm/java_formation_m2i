import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { SearchbarComponent } from './components/searchbar/searchbar.component';
import { PokemonDisplayComponent } from './components/pokemon-display/pokemon-display.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchbarComponent,
    PokemonDisplayComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
