import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { TestHomePageComponent } from './test/pages/test-home-page/test-home-page.component';
import { OtherHomePageComponent } from './other/pages/other-home-page/other-home-page.component';
import { Error404PageComponent } from './pages/errors/error-404-page/error-404-page.component';

// Il faut passer par un tableau de Route OU par un objet Routes pour définir les routes
const mesRoutes: Routes = [
  // Chaque route est à définir dans un objet
  { path: "", component: HomePageComponent },
  {
    // le path ne doit PAS être précédé pas un slash !
    path: "test",
    // Il faut préciser le composant (parent) de la page à afficher
    component: TestHomePageComponent
  }, 
  { path: "other", component: OtherHomePageComponent },
  // Pour envoyer vers une page d'erreur si la route n'est pas définie
  // ATTENTION à toujours mettre les routes avec wildcards en fin de tableau !
  { path: "**", component: Error404PageComponent }
];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    // Module à ajouter pour faire du routing
    // IL faut appliquer .forRoot() pour ajouter les routes de l'application
    // et lui passer un tableau d'objets Route
    RouterModule.forRoot(mesRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
