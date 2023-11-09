import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TestHeaderComponent } from './test/components/test-header/test-header.component';
import { TestBodyComponent } from './test/components/test-body/test-body.component';
import { TestHomePageComponent } from './test/pages/test-home-page/test-home-page.component';
import { OtherBodyComponent } from './other/components/other-body/other-body.component';
import { OtherHeaderComponent } from './other/components/other-header/other-header.component';
import { OtherHomePageComponent } from './other/pages/other-home-page/other-home-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { Error404PageComponent } from './pages/errors/error-404-page/error-404-page.component';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    TestHeaderComponent,
    TestBodyComponent,
    TestHomePageComponent, 
    OtherHeaderComponent,
    OtherBodyComponent,
    OtherHeaderComponent,
    OtherHomePageComponent,
    HomePageComponent, 
    Error404PageComponent
  ],
  imports: [
    BrowserModule,
    // Il faut importer le module de routing
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
