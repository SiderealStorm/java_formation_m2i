import { Component, OnDestroy, ViewChild, ElementRef } from '@angular/core';
import { AlbumFormMode, AlbumService } from './services/album.service';
import { Album } from './models/Album.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {

  albums: Album[] = [];
  albumsSub: Subscription | undefined;
  
  formMode: AlbumFormMode = null;
  formModeSub: Subscription | undefined;

  sort: keyof Album = "id";

  constructor(private albumService: AlbumService) {
    this.albumsSub = this.albumService.albums$.subscribe(data => this.albums = data);
    this.formModeSub = this.albumService.currentMode$.subscribe(data => this.formMode = data);
  }

  ngOnDestroy(): void {
    this.albumsSub?.unsubscribe();
    this.formModeSub?.unsubscribe();
  }

  getModalTitle() {
    switch (this.formMode) {
      case "add" :
        return "Ajouter un album";
      case "edit" :
        return "Modifier l'album";
      case "delete" :
        return "Supprimer l'album";
      default :
        return "";
    }
  }

  closeModal() {
    this.albumService.changeFormMode(null);
  }

  onClickAdd() {
    this.albumService.changeFormMode("add");
  }
}
