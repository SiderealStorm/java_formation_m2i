import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {
  constructor(
    private service: DataService,
    // Pour naviguer via le TS, il faut utiliser un Router
    private router: Router
    ) {
    console.log("Au lancement de HomePage, la valeur dans mon service est : " + this.service.testValue);

    this.service.testValue = "Value from Home page"
    
    console.log("Après changement dans Home, la valeur dans mon service est : " + this.service.testValue);
  }

  onClickNavigate() {
    console.log("Navigation vers /about via une méthode");
    // La méthode navigate prend en paramètre un tableau, contenant tous les paramètres de la route (ex : ['contact', 'detail', 1] = contact/details/1)
    this.router.navigate(['about'])
  }
}
