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
import { ProductFormPageComponent } from './products/pages/product-form-page/product-form-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ProductListPageComponent,
    Error404PageComponent,
    NavbarComponent,
    ProductFormComponent,
    ProductDisplayComponent,
    ProductFormPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
