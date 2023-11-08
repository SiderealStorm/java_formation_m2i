import { Component, Input } from '@angular/core';
import { Album } from 'src/app/models/Album.model';
import { AlbumService } from 'src/app/services/album.service';

@Component({
  selector: 'app-display-album',
  templateUrl: './display-album.component.html',
  styleUrls: ['./display-album.component.css']
})
export class DisplayAlbumComponent {

  @Input({
    required: true
  })
  album!: Album;

  constructor(private service: AlbumService) {}

  onClickEdit() {
    this.service.changeFormMode("edit");
    this.service.changeSelectedAlbum(this.album);
  }

  onClickDelete() {
    this.service.changeFormMode("delete");
    this.service.changeSelectedAlbum(this.album);
  }
}
