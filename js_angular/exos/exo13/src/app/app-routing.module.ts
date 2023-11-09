import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ContactHomePageComponent } from './contact/pages/contact-home-page/contact-home-page.component';
import { AboutPageComponent } from './about/pages/about-page/about-page.component';
import { Error404pageComponent } from './pages/error/error404page/error404page.component';
import { ContactListPageComponent } from './contact/pages/contact-list-page/contact-list-page.component';

const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'contacts', component: ContactHomePageComponent},
  {path: 'contacts/list', component: ContactListPageComponent},
  {path: 'about', component: AboutPageComponent},
  {path: '**', component: Error404pageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
