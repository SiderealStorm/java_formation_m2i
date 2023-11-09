import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Product } from '../models/Product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductsDataService {

  products$ = new BehaviorSubject<Product[]>([
    {
      name: "Tomate",
      price: 0.39
    },
    {
      name: "Oeuf",
      price: 0.19
    },
    {
      name: "Farine",
      price: 0.79
    }
  ])

  constructor() { }

  getProductByName(name: string) {
    return this.products$.getValue().find(p => p.name === name) ?? null;
  }
}
