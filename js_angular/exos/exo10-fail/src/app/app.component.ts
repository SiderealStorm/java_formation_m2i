import { Component, OnInit, OnDestroy } from '@angular/core';
import { Album } from './models/Album.model';
import { DatabaseService } from './services/database.service';
import {Subscription } from "rxjs";
import Mode from './models/Mode.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {
  
  albums: Album[] = [];
  albumsSub: Subscription | undefined
  modalVisibility: string = "";

  constructor(private dbService : DatabaseService) {}

  ngOnInit(): void {
    this.albumsSub = this.dbService.$albums.subscribe({
      next: (albums) => {
        this.albums = albums;
      }
    });
  }

  ngOnDestroy(): void {
    if (this.albumsSub) {
      this.albumsSub.unsubscribe();
    }
  }

  onClickAddAlbum() {
    this.modalVisibility = Mode.ADD;
  }

  onClickDelete() {
    this.dbService.deleteAlbum();
  }

  changeModalVisibility(value: string) {
    this.modalVisibility = value;
  }

}
