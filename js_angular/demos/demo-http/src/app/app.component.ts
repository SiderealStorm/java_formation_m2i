import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { map } from 'rxjs';

interface Pokemon {
  name: string,
  id: number
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-http';


  // Pour faire des requêtes API, il faut utiliser HttpClient
  constructor(private http: HttpClient) {

    // Header sous forme de HashMap/Record
    let headersRecord = {
      "Authorization": `Bearer ${this.getToken()}`
    }

    // Header sous forme d'objet HttpHeaders
    let headersObject = new HttpHeaders();
    // On utilise les méthodes .append() et .set pour ajouter des éléments
    // HttpHeaders ets immutable, il faut réassigner la valeur de retour de la méthode
    headersObject = headersObject.set("Authorization", `Bearer ${this.getToken()}`)
    // On peut simplifier la syntaxe :
    headersObject = new HttpHeaders().append("Authorization", `Bearer ${this.getToken()}`);

    // Pour faire une requête, on utilise les méthodes de HttpClient (get, post, etc.)
    // Contrairement à JS, l'élément retourné n'est pas une Promesse mais un Observable
    // La méthode .get() utilise les génériques, on peut donc la typer sinon on reçoit un any
    this.http.get<Pokemon>("https://pokeapi.co/api/v2/pokemon/ninetales", {
      // On peut définir des headers ou autre en second paramètre de la méthode
      // On peut passer par HttpHeaders OU pas un Record (= dictionnaire)
      headers: headersObject
      // headers: headersRecord
    })
    // On peut filtrer les données en amont pour les réduire
    .pipe(
      map(data => {
        return {
          id: data.id,
          name: data.name
        }
      })
    )
    .subscribe(data => {
      console.log(data);
      console.log(data.name);
      
    });

    interface PostApiResponse {
      userId: number,
      id: number,
      title: string,
      body: string
    }

    // Pour faire un POST :
    this.http.post<PostApiResponse>("http://jsonplaceholder.typicode.com/posts", {
      userId: 1,
      id: 22,
      title: "Titre du poste",
      body: "Le contenu de mon poste"
    }).subscribe(result => {
      console.log(result);
      localStorage.setItem("titre", result.title);
    });
  }

  // Pour stocker un élément dans le localStorage (idéalement via un service) :
  storeToken(token: string) {
    // La valeur stockée ne peut être qu'une string ; si on veut passer un objet il faut passer par Json.stringify()
    // ATTENTION stocker des données en cookie ou en localStorage n'est pas sécurisé, sauf éventuellement si hashé
    localStorage.setItem("jwtToken", token);
  }

  // Récupérer un élément dans le localStorage (idéalement via un service) :
  getToken() {
    // Comme la valeur est toujours une string OU null, si on voulait un élément sous forme d'objet il faut
    // d'abord vérifier qu'il n'est pas null puis utiliser JSON.parse(elt) (renvoie un objet anonyme, donc de type any)
    const token = localStorage.getItem("jwtToken");
    console.log(token);
    return token;
  }

  // Retirer un élément du localStorage :
  clearLocalStorage() {
    localStorage.removeItem("jwtToken");
    localStorage.removeItem("titre");
  }
}
