import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Product } from 'src/app/models/Product.model';

type FormMode = "details" | "add" | "edit" | "delete";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  count = 0;

  products$ = new BehaviorSubject<Product[]>([
    {
      id: -1,
      name: "Produit n°-1",
      description: "Produit test",
      price: 0.99,
      stock: 1
    },
    {
      id: -2,
      name: "Produit n°-2",
      description: "Produit test",
      price: 10.99,
      stock: 10
    }
  ]);
  
  currentFormMode$ = new BehaviorSubject<FormMode>("details");

  constructor() { }

  getProductById(productId: number) {
    return this.products$.getValue().find(product => product.id === productId) ?? null;
  }

  addProduct(newProduct: Product) {
    newProduct.id = ++this.count;
    this.products$.next([...this.products$.getValue(), newProduct]);
  }

  editProduct(productValues: Product) {
    const foundProduct = this.getProductById(productValues.id);
    if (foundProduct) {
      this.products$.next([
        ...this.products$.getValue().filter(product => product.id !== foundProduct.id),
        productValues
      ]);
    }
  }

  deleteProductById(productId: number) {
    this.products$.next([...this.products$.getValue().filter(product => product.id !== productId)]);
  }

  changeFormMode(mode: FormMode) {
    this.currentFormMode$.next(mode);
  }
}

export { FormMode };
