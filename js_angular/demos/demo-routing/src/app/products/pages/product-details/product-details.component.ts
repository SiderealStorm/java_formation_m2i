import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from 'src/app/models/Products.model';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent {

  product: Product | null = null;

  constructor (
    private service: ProductService,
    // Pour récupérer la route actuelle, il faut utiliser aActivatedRoute
    private route: ActivatedRoute,
    private router: Router
  ) {
    // Les méthodes de ActivatedRoute sont des observables
    // Pour ne pas avoir de "suivi" (sans observables), on passe par snapshot
    // // La méthode .params() permet de récupérer les paramètres de route tels que définis dans le routing
    // this.route.snapshot.params['productId']
    
    // Si on préfère que l'élément soit possiblement null au lieu de undefined, on peut utiliser paramMap.get()
    const productId = +(this.route.snapshot.paramMap.get("productId") ?? 0);

    // // Si plusieurs paramètres (utiliser les mêmes noms de variables que dans le routing) :
    // const { paramA, paramB, paramC } = this.route.snapshot.params;

    this.product = this.service.getProductById(productId);


    // Paramètres optionnels :

    // Navigation
    this.router.navigate([], {
      queryParams: {"varA": "test"}
    });

    // Récupération (en temps réel avec un observable)
    this.route.queryParamMap.subscribe((params: ParamMap) => {
      console.log(params.get("varA"));
      
    })
  }
}
