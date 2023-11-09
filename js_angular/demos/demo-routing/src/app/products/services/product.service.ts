import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Product } from 'src/app/models/Products.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  counter = 0;
  products$ = new BehaviorSubject<Product[]>([]);

  constructor() { }

  getProductById(productId: number) {
    return this.products$.getValue().find(p => p.id === productId) ?? null;
  }

  addProduct(newProduct: Product) {
    newProduct.id = ++this.counter;
    newProduct.name = "Produit n°" + newProduct.id;
    this.products$.next([...this.products$.getValue(), newProduct]);
  }
}
