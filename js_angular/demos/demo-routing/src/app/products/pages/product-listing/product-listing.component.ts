import { Component, OnDestroy } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from 'src/app/models/Products.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-product-listing',
  templateUrl: './product-listing.component.html',
  styleUrls: ['./product-listing.component.css']
})
export class ProductListingComponent implements OnDestroy {

  products: Product[] = [];
  productsSub: Subscription | undefined;

  constructor(private service: ProductService) {
    this.productsSub = this.service.products$.subscribe(data => this.products = data);
  }

  ngOnDestroy(): void {
    this.productsSub?.unsubscribe();
  }

  onClickAddProduct() {
    const newProduct: Product = {
      name: "Mon produit",
      description: "Description de mon produit",
      price: +(Math.random() * 20).toFixed(2),
      stock: Math.round(Math.random() * 200)
    }

    this.service.addProduct(newProduct);
  }
}
