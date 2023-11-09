import { Component, ViewChild, ElementRef } from '@angular/core';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent {

  @ViewChild("searchValue") searchInputRef: ElementRef<HTMLInputElement> | undefined;

  constructor(private service: PokemonService) {}

  onSubmitSearch(event: Event) {
    event.preventDefault();
    
    if (this.searchInputRef) {
      // Ne pas oublier d'ajouter un .trim() pour éviter d'envoyer des espaces qui génèrenaient un 404
      this.service.changeCurrentPokemon(this.searchInputRef.nativeElement.value.trim());
    }
  }
}
