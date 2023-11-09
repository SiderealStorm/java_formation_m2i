import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-list-page',
  templateUrl: './product-list-page.component.html',
  styleUrls: ['./product-list-page.component.css']
})
export class ProductListPageComponent {

  constructor(
    private router: Router,
    private service: ProductService
  ) {}

  onClickAdd() {
    this.service.changeFormMode("add");
    this.router.navigate(["products", "add"]);
  }
}
