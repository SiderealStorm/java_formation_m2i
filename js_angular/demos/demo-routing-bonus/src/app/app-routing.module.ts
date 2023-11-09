import { NgModule, inject } from '@angular/core';
import { CanActivateFn, Router, RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ProductListingPageComponent } from './products/pages/product-listing-page/product-listing-page.component';
import { ProductDetailsPageComponent } from './products/pages/product-details-page/product-details-page.component';
import { Error404PageComponent } from './pages/errors/error-404-page/error-404-page.component';
import { ProfilePageComponent } from './admin/pages/profile-page/profile-page.component';
import { AuthService } from './services/auth.service';

// Fonction CanActivate :
const myCanActivate: CanActivateFn = (route, state) => {
  // Pour obtenir un service (qui est providedIn: 'root') malgré qu'on n'a pas de constructeur, on l'injecte dans une constante
  const authService = inject(AuthService);

  // Ppour obtenir un booléen à partir d'un truthy/falsy, inverse deux fois :
  const isValid = !!authService.user$.getValue();

  // On vérifie la validité de l'authentification :
  if (!isValid) {
    // Si pas connecté, on redirige via le router
    const router = inject(Router);
    // Idéalement, on redirige vers le formulaire de connexion
    return router.parseUrl('/');
  }
  // Si connecté, on retourne true
  return true;
}

const routes: Routes = [
  {path: '', component: HomePageComponent},
  // Définir des routes enfant (= router-outlet dans un composant) :
  {path: 'products', component: ProductListingPageComponent, children: [
    {path: ':name', component: ProductDetailsPageComponent }
  ]},
  // Pour sécuriser une route, il faut lui passer des canActivateFunctions
  {path: 'admin', component: ProfilePageComponent, canActivate: [myCanActivate]},
  {path: '**', component: Error404PageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
