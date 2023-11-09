import { Component, Input, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { Product } from 'src/app/models/Product.model';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-display',
  templateUrl: './product-display.component.html',
  styleUrls: ['./product-display.component.css']
})
export class ProductDisplayComponent implements OnDestroy {

  productsList: Product[] = [];
  productsListSub: Subscription | undefined;

  constructor(
    private service: ProductService
  ) {
    this.productsListSub = this.service.products$.subscribe(data => this.productsList = data);
  }

  ngOnDestroy(): void {
    this.productsListSub?.unsubscribe();
  }

}
