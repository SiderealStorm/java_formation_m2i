import { Component, OnDestroy } from '@angular/core';
import { AlbumFormMode, AlbumService } from './services/album.service';
import { Album } from './models/Album.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {

  formMode: AlbumFormMode = null;

  albums: Album[] = [];
  albumsSub: Subscription | undefined;

  selectedAlbum: Album | null = null;
  selectedAlbumSub: Subscription | undefined;

  constructor(private albumService: AlbumService) {
    this.albumsSub = this.albumService.albums$.subscribe(data => this.albums = data);
    this.selectedAlbumSub = this.albumService.selectedAlbum$.subscribe(data => this.selectedAlbum = data);
  }

  ngOnDestroy(): void {
    this.albumsSub?.unsubscribe();
    this.selectedAlbumSub?.unsubscribe();
  }

  onClickAdd() {
    this.albumService.changeFormMode("add");
  }
}
