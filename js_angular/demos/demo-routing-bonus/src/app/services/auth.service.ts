import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from '../models/User.model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // Pour savoir en temps réel si un utilisateur est connecté, on stocke l'utilisateur actuel dans le service
  user$ = new BehaviorSubject<User | null>(null);

  constructor(
    private router: Router
  ) {
    const token = this.getToken();

    if (token) {
      console.log("Auto-login");

      // Requête
      const requestOk = true;

      // On vérifie que la requête a réussi
      if (requestOk) {
        this.user$.next({
          name: "Admin",
          email: "admin@mail.com"
        });
      }
    }
  }

  logIn() {
    // Idéalement, cette méthode fait une requête API vers le backend et met à jour l'utilisateur si l'authentification a réussi
    this.user$.next({
      name: "Admin",
      email: "admin@mail.com"
    });
    localStorage.setItem("jwt", "mon.token.JWT")
  }
  
  // Il est préférable de mettre la récupération du token dans une méthode
  // au cas où le mode de stockage change
  getToken() {
    return localStorage.getItem('jwt');
  }

  // Au choix : soit déclanché par un bouton, soit aussi automatiquement à la fermeture de l'application mais dans ce cas l'auto-login n'est plus utilisable.
  // On peut aussi auto-logout en prenant en compte l'expiration du token JWT
  logOut() {
    this.user$.next(null);
    localStorage.removeItem('jwt');
    // On définit une redirection au moment de la déconnexion :
    this.router.navigate(['']);
  }
}
