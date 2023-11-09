import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ProductListPageComponent } from './products/pages/product-list-page/product-list-page.component';
import { Error404PageComponent } from './pages/errors/error-404-page/error-404-page.component';
import { ProductFormPageComponent } from './products/pages/product-form-page/product-form-page.component';
const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'products', component: ProductListPageComponent },
  { path: 'products/add', component: ProductFormPageComponent },
  { path: 'products/details/:id', component: ProductFormPageComponent },
  { path: 'products/edit/:id', component: ProductFormPageComponent },
  { path: 'products/delete/:id', component: ProductFormPageComponent },
  // // Simplifiable ?
  // { path: 'products/:formMode/:id', component: ProductFormPageComponent },
  { path: "**", component: Error404PageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
