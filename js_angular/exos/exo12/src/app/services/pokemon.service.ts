import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, BehaviorSubject, catchError, of } from 'rxjs';
import { Pokemon } from '../models/Pokemon.model';

const baseUrl = "https://pokeapi.co/api/v2/pokemon/";

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  maxPokeId = 1017;
  maxImgId = 1011;

  currentPokemon$ = new BehaviorSubject<Pokemon | null>(null);

  constructor(private http: HttpClient) { }

  changeCurrentPokemon(idOrName : string = "") {
    if (!idOrName) {
      idOrName = Math.floor(Math.random() * this.maxPokeId).toString();
    }

    this.getPokemon(idOrName).subscribe(data => this.currentPokemon$.next(data));
  }

  getPokemon(idOrName : string) {
    return this.http.get<any>(baseUrl + idOrName)
      .pipe(
        catchError(error => of(error)),
        map(data => {
          return {
            id: data.id,
            name: data.name,
            height: data.height,
            weight: data.weight,
            types: data.types.map((element: any) => element.type.name),
            abilities: data.abilities.map((element: any) => element.ability.name),
            imageUrl: this.getPokemonImage(data.id)
          } as Pokemon;
        })
      )
  }

  getPokemonImage(id: number) {
    if (id < this.maxImgId) {
      return `https://assets.pokemon.com/assets/cms2/img/pokedex/full/${id.toString().padStart(3, "0")}.png`;
    } else {
      return "assets/images/Poke_Ball.webp";
    }
  }
}
