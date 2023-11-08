import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ProductListPageComponent } from './products/pages/product-list-page/product-list-page.component';
import { Error404PageComponent } from './pages/errors/error-404-page/error-404-page.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProductFormComponent } from './products/components/product-form/product-form.component';
import { ProductDisplayComponent } from './products/components/product-display/product-display.component';
import { ProductAddPageComponent } from './products/pages/product-add-page/product-add-page.component';
import { ProductEditPageComponent } from './products/pages/product-edit-page/product-edit-page.component';
import { ProductDeletePageComponent } from './products/pages/product-delete-page/product-delete-page.component';
import { ProductDetailsPageComponent } from './products/pages/product-details-page/product-details-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ProductListPageComponent,
    Error404PageComponent,
    NavbarComponent,
    ProductFormComponent,
    ProductDisplayComponent,
    ProductAddPageComponent,
    ProductEditPageComponent,
    ProductDeletePageComponent,
    ProductDetailsPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
