import { Component, OnDestroy } from '@angular/core';
import { DogFormMode, DogService } from './services/dog.service';
import { Subscription } from 'rxjs'
import Dog from './models/Dog.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {
  dogFormMode: DogFormMode = null;
  dogFormModeSub: Subscription | undefined;

  dogs: Dog[] = [];
  dogsSub: Subscription | undefined;

  constructor (private dogService: DogService) {
    // On a seulement besoin du next, donc pas besoin d'objet de configuration
    this.dogFormModeSub = this.dogService.dogFormMode$.subscribe(mode => this.dogFormMode = mode);
    this.dogsSub = this.dogService.dogs$.subscribe(dogs => this.dogs = dogs);
  }

  ngOnDestroy(): void {
    this.dogFormModeSub?.unsubscribe();
    this.dogsSub?.unsubscribe();
  }

  onClickAdd() {
    this.dogService.switchDogFormMode("add");
  }

  closeModal() {
    this.dogService.switchDogFormMode(null);
  }
}
