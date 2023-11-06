import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { NameService } from 'src/app/services/name.service';

@Component({
  selector: 'app-names-list',
  templateUrl: './names-list.component.html',
  styleUrls: ['./names-list.component.css']
})
export class NamesListComponent implements OnInit, OnDestroy {

  namesList: string[] = [];
  namesSub: Subscription | undefined;

  constructor(private nameService : NameService) {}

  ngOnInit() {
    this.namesSub = this.nameService.$names
    .subscribe({
      next: (names) => {
        this.namesList = names;
      }
    })
  }

  ngOnDestroy(): void {
    if (this.namesSub) {
      this.namesSub.unsubscribe();
    }
  }
}
