import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormMode, ProductService } from '../../services/product.service';
import { Product } from 'src/app/models/Product.model';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements AfterViewInit {

  productId: number;
  product: Product | null;

  formMode: FormMode;

  @ViewChild("name") productNameRef!: ElementRef<HTMLInputElement>
  @ViewChild("description") productDescrRef!: ElementRef<HTMLInputElement>
  @ViewChild("price") productPriceRef!: ElementRef<HTMLInputElement>
  @ViewChild("stock") productStockRef!: ElementRef<HTMLInputElement>
  
  constructor(
    private router: Router,
    private service: ProductService,
    private route: ActivatedRoute
  ) {
    this.productId = +(this.route.snapshot.paramMap.get("id") ?? 0);
    this.product = this.service.getProductById(this.productId);
    this.formMode = this.service.currentFormMode$.getValue();
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

    const formValues: Product = {
      id: this.productId,
      name: this.productNameRef.nativeElement.value,
      description: this.productDescrRef.nativeElement.value,
      price: +this.productPriceRef.nativeElement.value,
      stock: +this.productStockRef.nativeElement.value
    }

    switch (this.formMode) {
      case "add" :
        this.service.addProduct(formValues);
        break;
      case "edit" :
        this.service.editProduct(formValues);
        break;
      case "delete" :
        this.service.deleteProductById(this.productId);
        break;
    }

    this.router.navigate(['/products']);
  }

  getRequired() {
    switch (this.formMode) {
      case "add" :
        return true;
      case "edit" :
        return true;
      case "delete" :
        return false;
      case "details" :
        return false;
    }
  }

}
