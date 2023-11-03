import { AfterContentInit, AfterViewInit, Component, ContentChild, ElementRef, Input, OnChanges, OnDestroy, OnInit, SimpleChanges, ViewChild } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnChanges, OnInit, AfterContentInit, AfterViewInit, OnDestroy {

  @Input()
  text = "Texte par défaut"

  // On peut aussi créer les variables des éléments HTML dans le TS grâce à @ViewChild('nomRéférence')
  @ViewChild('firstName')
  firstNameRef!: ElementRef<HTMLInputElement>;

  @ViewChild('lastName')
  lastNameRef!: ElementRef<HTMLInputElement>;
  
  // Si l'élément n'est pas déclaré dans le template mais dans son contenu (= ng-template)
  @ContentChild('age')
  ageElementRef!: ElementRef<HTMLInputElement>;


  // Le constructeur est la première étape du cycle de vie
  constructor() {
    console.log("Appel du constructeur de app-first");
    // mais les variable importées ne sont pas encore chargées !
    console.log("text : " + this.text);
    console.log("firstNameRef : " + this.firstNameRef);
    console.log("ageElementRef : " + this.ageElementRef);
    
  }

  // L'initialisation du composant se fait pendant l'étape onChanges
  ngOnChanges(changes: SimpleChanges): void {
    console.log("Appel de la méthode ngOnChanges()");
    console.log(changes);
    // Les variable @Input sont chargées lors de l'initialisation
    console.log("text : " + this.text);
    // mais pas les références à des composants HTML
    console.log("firstNameRef : " + this.firstNameRef);
    console.log("ageElementRef : " + this.ageElementRef);
  }

  // L'initialisation est faite à l'étape onInit
  ngOnInit(): void {
    console.log("Appel de la méthode ngOnInit()");
    // Si on veut charger un @Input une seule fois, OnInit est préférable à OnChanges
    console.log("text : " + this.text);
    console.log("firstNameRef : " + this.firstNameRef);
    console.log("ageElementRef : " + this.ageElementRef);
  }

  // 
  ngAfterContentInit(): void {
    console.log("Appel de la méthode ngAfterContentInit()");
    console.log("text : " + this.text);
    console.log("firstNameRef : " + this.firstNameRef);
    // Les variables issues de références dans le template sont chargées
    console.log("ageElementRef : " + this.ageElementRef);
  }

  // Ensuite se fait l'itinialisation de la vue
  ngAfterViewInit(): void {
    console.log("Appel de la méthode ngAfterViewInit()");
    console.log("text : " + this.text);
    // Les variables issues de références sont chargées
    console.log("firstNameRef : " + this.firstNameRef);
    console.log("ageElementRef : " + this.ageElementRef);
  }

  // OnDestroy est la dernière étape, qui correspond à la destruction du composant
  ngOnDestroy(): void {
    console.log("Appel de la méthode ngOnDestroy()");
    console.log("text : " + this.text);
    console.log("firstNameRef : " + this.firstNameRef);
    console.log("ageElementRef : " + this.ageElementRef);
  }



  onLogForm() {
    const user = {
      // On peut récupérer les valeurs car on a typé l'élément
      firstName: this.firstNameRef.nativeElement.value,
      lastName: this.lastNameRef.nativeElement.value,
      age: this.ageElementRef.nativeElement.value
    }
    console.log(user);
  }
}
