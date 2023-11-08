import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ProductListPageComponent } from './products/pages/product-list-page/product-list-page.component';
import { ProductAddPageComponent } from './products/pages/product-add-page/product-add-page.component';
import { ProductDetailsPageComponent } from './products/pages/product-details-page/product-details-page.component';
import { ProductEditPageComponent } from './products/pages/product-edit-page/product-edit-page.component';
import { ProductDeletePageComponent } from './products/pages/product-delete-page/product-delete-page.component';
import { Error404PageComponent } from './pages/errors/error-404-page/error-404-page.component';
const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'products', component: ProductListPageComponent },
  { path: 'products/add', component: ProductAddPageComponent },
  { path: 'products/details/:id', component: ProductDetailsPageComponent },
  { path: 'products/edit/:id', component: ProductEditPageComponent },
  { path: 'products/delete/:id', component: ProductDeletePageComponent },
  { path: "**", component: Error404PageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
