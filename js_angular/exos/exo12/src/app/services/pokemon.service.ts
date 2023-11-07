import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, BehaviorSubject, catchError } from 'rxjs';
import { Pokemon } from '../models/Pokemon.model';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  maxPokeId = 1017;
  maxImgId = 1011;

  baseUrl = "https://pokeapi.co/api/v2/pokemon/";

  requestHasError = false;

  currentPokemon$ = new BehaviorSubject<Pokemon | null>(null);

  constructor(private http: HttpClient) { }

  changeCurrentPokemon(idOrName : string = "") {
    if (!idOrName) {
      idOrName = Math.floor(Math.random() * this.maxPokeId).toString();
    }

    this.getPokemon(idOrName).subscribe({
        next: (data) => {
          this.currentPokemon$.next(data);
        },
        error: (error) => {
          this.requestHasError = true;
        }
      });

      if(this.requestHasError) {
        this.getPokemon(idOrName).subscribe(data => this.currentPokemon$.next(data));
      }
  }

  getPokemon(idOrName : string) {
    return this.http.get<any>(this.baseUrl + idOrName)
      .pipe(
        // catchError(_error => this.getPokemon("")),
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
