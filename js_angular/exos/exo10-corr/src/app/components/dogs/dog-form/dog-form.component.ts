import { Component, ViewChild, ElementRef, OnDestroy, AfterViewInit } from '@angular/core';
import { Subscription } from 'rxjs';
import Dog from 'src/app/models/Dog.model';
import { DogFormMode, DogService } from 'src/app/services/dog.service';
// Pour utiliser les UUID, il faut installer le package correspondant et le type associé :
// $ npm i uuid && $ npm i -D @types/uuid
// Import de la version à utiliser
import { v4 as uuid } from 'uuid';

@Component({
  selector: 'app-dog-form',
  templateUrl: './dog-form.component.html',
  styleUrls: ['./dog-form.component.css']
})
export class DogFormComponent implements OnDestroy, AfterViewInit {

  selectedDog: Dog | null = null;
  selectedDogSub: Subscription | undefined;

  dogFormMode: DogFormMode | null = "add";
  dogFormModeSub: Subscription | undefined;

  @ViewChild("name") nameInputRef: ElementRef<HTMLInputElement> | undefined
  @ViewChild("breed") breedInputRef: ElementRef<HTMLInputElement> | undefined
  @ViewChild("birthDate") birthDateInputRef: ElementRef<HTMLInputElement> | undefined
  
  constructor(private dogService: DogService) {
    this.selectedDogSub = this.dogService.selectedDog$.subscribe(dog => this.selectedDog = dog);
    this.dogFormModeSub = this.dogService.dogFormMode$.subscribe(mode => this.dogFormMode = mode);
  }

  ngAfterViewInit(): void {
    // Si on n'ajoute pas de chien, on peuple le formulaire avec le chien sélectionné
    if (this.selectedDog) {
      if (this.nameInputRef) {
        this.nameInputRef.nativeElement.value = this.selectedDog?.name;
      }
      if (this.breedInputRef) {
        this.breedInputRef.nativeElement.value = this.selectedDog?.breed;
      }
      if (this.birthDateInputRef) {
        this.birthDateInputRef.nativeElement.valueAsDate = this.selectedDog?.birthDate;
      }
    }
  }

  ngOnDestroy(): void {
    this.selectedDogSub?.unsubscribe();
    this.dogFormModeSub?.unsubscribe();
  }

  getRequired() {
    return this.dogFormMode && (this.dogFormMode === "add" || this.dogFormMode === "edit");
  }

  getReadOnly() {
    return this.dogFormMode && this.dogFormMode === "delete";
  }

  getButtonText() {
    switch (this.dogFormMode) {
      case "delete":
        return "Confirmer la suppression";
      case "edit":
        return "Modifier";
      default:
      return "Ajouter";
    }
  }

  onSubmitForm(event: Event) {
    event.preventDefault();

    const formValues: Dog = {
      // Si pas de chien sélectionné, on génère un UUID
      id: this.selectedDog ? this.selectedDog.id : uuid(),
      // On définit des valeurs par défaut pour que l'objet corresponde à un chien
      name: this.nameInputRef?.nativeElement.value ?? "Inconnu",
      breed: this.breedInputRef?.nativeElement.value ?? "Inconnue",
      birthDate: this.birthDateInputRef?.nativeElement.valueAsDate ?? new Date()
    }

    switch (this.dogFormMode) {
      case "edit" :
        this.dogService.editDog(formValues);
        break
      case "delete" :
        this.dogService.deleteDogById(formValues.id);
        break
      default :
        this.dogService.addDog(formValues);
    }

    // Pour fermer le modal :
    this.dogService.switchDogFormMode(null);
  }
}
