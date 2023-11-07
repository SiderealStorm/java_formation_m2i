import { Component, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { Pokemon } from 'src/app/models/Pokemon.model';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-pokemon-display',
  templateUrl: './pokemon-display.component.html',
  styleUrls: ['./pokemon-display.component.css']
})
export class PokemonDisplayComponent implements OnDestroy {

  pokemon: Pokemon | null = null;
  pokemonSub: Subscription | undefined;

  constructor(private service: PokemonService) {
    this.pokemonSub = this.service.currentPokemon$.subscribe(data => this.pokemon = data);
    this.service.changeCurrentPokemon();
  }

  ngOnDestroy(): void {
    this.pokemonSub?.unsubscribe();
  }

  onClickSwitchPokemon(value: number) {
    this.service.changeCurrentPokemon(this.pokemon ? (this.pokemon.id + value).toString() : "")
  }
  
  getDisabled() {
    return this.service.maxPokeId === this.pokemon?.id;
  }
}
