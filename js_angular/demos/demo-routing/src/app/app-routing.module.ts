import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutPageComponent } from './components/about-page/about-page.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ProductListingComponent } from './products/pages/product-listing/product-listing.component';
import { ProductDetailsComponent } from './products/pages/product-details/product-details.component';

const routes: Routes = [
  {path: "", component: HomePageComponent},
  {path: "about", component: AboutPageComponent},
  {path: "products", component: ProductListingComponent},
  // Pour avoir des paramètres dynamiques dans une url, on utilise la syntaxe :variable
  {path: "products/:productId", component: ProductDetailsComponent},
  // Pour faire une redirection :
  {path: "product", redirectTo: "products", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
