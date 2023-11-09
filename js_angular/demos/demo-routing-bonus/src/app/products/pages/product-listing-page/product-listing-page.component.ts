import { Component } from '@angular/core';
import { ProductsDataService } from '../../services/products-data.service';
import { Product } from '../../models/Product.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-product-listing-page',
  templateUrl: './product-listing-page.component.html',
  styleUrls: ['./product-listing-page.component.css']
})
export class ProductListingPageComponent {

  products: Product[] = [];
  productsSub: Subscription | undefined;

  constructor(
    private service: ProductsDataService
  ) {
    this.productsSub = this.service.products$.subscribe(data => this.products = data);
  }
}
