import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Product } from 'src/app/models/Product.model';

type FormMode = "details" | "add" | "edit" | "delete";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  count = 0;

  products$ = new BehaviorSubject<Product[]>([]);
  selectedProduct$ = new BehaviorSubject<Product | null>(null);
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

  changeSelectedProduct(product: Product) {
    this.selectedProduct$.next(product);
  }

  changeFormMode(mode: FormMode) {
    this.currentFormMode$.next(mode);
  }
}

export { FormMode };
