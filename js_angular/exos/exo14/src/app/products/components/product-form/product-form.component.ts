import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { Product } from 'src/app/models/Product.model';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements AfterViewInit {

  productId: number;
  product: Product | null;

  @ViewChild("name") productNameRef: ElementRef<HTMLInputElement> | undefined
  @ViewChild("description") productDescrRef: ElementRef<HTMLInputElement> | undefined
  @ViewChild("price") productPriceRef: ElementRef<HTMLInputElement> | undefined
  @ViewChild("stock") productStockRef: ElementRef<HTMLInputElement> | undefined
  
  constructor(
    private router: Router,
    private service: ProductService,
    private route: ActivatedRoute
  ) {
    this.productId = +(this.route.snapshot.paramMap.get("id") ?? 0);
    this.product = this.service.getProductById(this.productId);
  }

  ngAfterViewInit(): void {
    if (this.product) {
      if (this.productNameRef) {
        this.productNameRef.nativeElement.value = this.product.name;
      }
      
      if (this.productDescrRef) {
        this.productDescrRef.nativeElement.value = this.product.description;
      }
      
      if (this.productPriceRef) {
        this.productPriceRef.nativeElement.value = this.product.price.toString();
      }
      
      if (this.productStockRef) {
        this.productStockRef.nativeElement.value = this.product.stock.toString();
      }
    }
  }

  onSubmitForm(event: Event) {
    event.preventDefault();

    console.log("Méthode non implémentée !");

    this.router.navigate(['/products']);
  }

}
