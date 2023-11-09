import { Component, OnDestroy } from '@angular/core';
import { Product } from '../../models/Product.model';
import { ProductsDataService } from '../../services/products-data.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-product-details-page',
  templateUrl: './product-details-page.component.html',
  styleUrls: ['./product-details-page.component.css']
})
export class ProductDetailsPageComponent implements OnDestroy {

  product!: Product;
  routeSub: Subscription | undefined;

  constructor(
    private service: ProductsDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    // On récupère le paramètre de route
    this.route.paramMap.subscribe((params: ParamMap) => {
      // On tente de récupérer le produit :
      const prodFound = this.service.getProductByName(params.get('name') ?? '');
      // Si pas de produit, redirection vers la page 404 :
      if (!prodFound) {
        this.router.navigate(['/not-found']);
      } else {
        this.product = prodFound;
      }
    });
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
  }
}
