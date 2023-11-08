import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactHomePageComponent } from './contact/pages/contact-home-page/contact-home-page.component';
import { AboutPageComponent } from './about/pages/about-page/about-page.component';
import { ContactHeaderComponent } from './contact/components/contact-header/contact-header.component';
import { ContactFooterComponent } from './contact/components/contact-footer/contact-footer.component';
import { ContactBodyComponent } from './contact/components/contact-body/contact-body.component';
import { ContactListComponent } from './contact/components/contact-list/contact-list.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { Error404pageComponent } from './pages/error/error404page/error404page.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ContactListPageComponent } from './contact/pages/contact-list-page/contact-list-page.component';

@NgModule({
  declarations: [
    AppComponent,
    ContactHomePageComponent,
    AboutPageComponent,
    ContactHeaderComponent,
    ContactFooterComponent,
    ContactBodyComponent,
    ContactListComponent,
    HomePageComponent,
    Error404pageComponent,
    NavbarComponent,
    ContactListPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
