import { Component, Input, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { Product } from 'src/app/models/Product.model';
import { ProductService } from '../../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-display',
  templateUrl: './product-display.component.html',
  styleUrls: ['./product-display.component.css']
})
export class ProductDisplayComponent implements OnDestroy {

  productsList: Product[] = [];
  productsListSub: Subscription | undefined;

  constructor(
    private service: ProductService,
    private router: Router
  ) {
    this.productsListSub = this.service.products$.subscribe(data => this.productsList = data);
  }

  ngOnDestroy(): void {
    this.productsListSub?.unsubscribe();
  }

  onClickDetails(id: number) {
    this.service.changeFormMode("details");
    this.router.navigate(['products', 'details', id]);
  }

  onClickEdit(id: number) {
    this.service.changeFormMode("edit");
    this.router.navigate(['products', 'edit', id]);
  }

  onClickDelete(id: number) {
    this.service.changeFormMode("delete");
    this.router.navigate(['products', 'delete', id]);
  }
}
