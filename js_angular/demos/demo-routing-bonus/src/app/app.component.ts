import { Component, OnDestroy } from '@angular/core';
import { User } from './models/User.model';
import { AuthService } from './services/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {
  user: User | null = null;
  userSub: Subscription | undefined;

  constructor(
    private service: AuthService
  ) {
    this.userSub = this.service.user$.subscribe(user => this.user = user);
  }

  ngOnDestroy(): void {
    this.userSub?.unsubscribe();
    // // Si on veut logout automatiquement en quittant l'application :
    // this.service.logOut();
  }

  signIn() {
    this.service.logIn();
  }

  signOut() {
    this.service.logOut();
  }
}
