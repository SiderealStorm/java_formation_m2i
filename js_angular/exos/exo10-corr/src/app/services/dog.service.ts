import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs'
import Dog from '../models/Dog.model';

// Pour gérer le type du formulaire :
type DogFormMode = "add" | "edit" | "delete" | null;

@Injectable({
  providedIn: 'root'
})
class DogService {

  // Pour informer les composants des chiens actuellement disponibles
  dogs$ = new BehaviorSubject<Dog[]>([]);

  // Pour informer du chien actuellement en cours de modification
  // Pour un objet, s'il peut ne pas être présent, il vaut mieux utiliser null que undefined
  selectedDog$ = new BehaviorSubject<Dog | null>(null);

  // Pour informer du mode actuel des formulaires
  dogFormMode$ = new BehaviorSubject<DogFormMode>(null);

  constructor() { }
  
  getDogById(dogId: string) {
    // expression ?? default : si l'expression "null" ou "undefined", on obtient la valeur default à la place
    return this.dogs$.getValue().find(dog => dog.id === dogId) ?? null;
  }
  
    // Méthodes de la liste de chiens
    addDog(newDog: Dog) {
      const currentDogs = this.dogs$.getValue();
      // Quand on utilise .next(), cela informe du changement tous les composants qui ont souscrit au Subject
      this.dogs$.next([...currentDogs, newDog]);
      console.log(this.dogs$.getValue());
    }

  deleteDogById(dogId: string) {
    // Facultatif, on pourrait passer directement par l'ID
    const dogToDelete = this.getDogById(dogId);
    if (dogToDelete) {
      this.dogs$.next(this.dogs$.getValue().filter(dog => dog !== dogToDelete));
    }
  }

  editDog(dogValues: Dog) {
    const dogToEdit = this.getDogById(dogValues.id);
    if (dogToEdit) {
      const editedDog: Dog = {
        ...dogValues,
        id: dogToEdit.id
      };
      // On remplace l'élément à modifier par l'objet modifié, via un nouveau tableau
      this.dogs$.next([...this.dogs$.getValue().filter(dog => dog.id !== editedDog.id), editedDog])
    }
  }

  // Méthode pour le chien sélectionné
  switchSelectedDog(dogId: string) {
    this.selectedDog$.next(this.getDogById(dogId));
  }

  // Méthode pour le mode du formulaire
  switchDogFormMode(dogFormMode: DogFormMode) {
    this.dogFormMode$.next(dogFormMode);
    // Si on ajoute un chien, il faut que le chien sélectionné soit null
    if (dogFormMode === "add") {
      this.selectedDog$.next(null);
    }
  }
}

// On exporte le type customisé :
export { DogService, DogFormMode };