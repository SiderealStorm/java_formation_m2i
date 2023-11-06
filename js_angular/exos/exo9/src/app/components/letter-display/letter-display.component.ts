import { Component, OnDestroy, OnInit } from '@angular/core';
import { CounterService } from 'src/app/services/counter.service';
import { Subscription } from 'rxjs'

@Component({
  selector: 'app-letter-display',
  templateUrl: './letter-display.component.html',
  styleUrls: ['./letter-display.component.css']
})
export class LetterDisplayComponent implements OnInit, OnDestroy {

  letter = "";

  // Ajout correction : variable pour stocker la souscription
  counterSub: Subscription | undefined;

  constructor(private service : CounterService) {}

  ngOnInit(): void {
    // On enregistre la souscription pour povoir la vérifier par la suite
    this.counterSub = this.service.getLetter().subscribe({
      next : (value) => {
        this.letter = value;
        console.log("Observable en cours d'utilisation");
      }
    });
  }

  // Ajout correction : désabonnement avec ngOnDestroy
  ngOnDestroy(): void {
    // Il est préférable de se désabonner systématiquement aux observables
    if (this.counterSub) {
      this.counterSub.unsubscribe();
    }
  }
}
