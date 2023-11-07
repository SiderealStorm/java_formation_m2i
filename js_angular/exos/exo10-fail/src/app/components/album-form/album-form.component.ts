import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { Album } from 'src/app/models/Album.model';
import { AlbumDTO } from 'src/app/models/AlbumDTO.model';
import Mode from 'src/app/models/Mode.model';
import { DatabaseService } from 'src/app/services/database.service';

@Component({
  selector: 'app-album-form',
  templateUrl: './album-form.component.html',
  styleUrls: ['./album-form.component.css']
})
export class AlbumFormComponent implements OnInit {

  @Input({
    required: true
  })
  mode !: string;

  album: Album | undefined;

  albumTitle !: string;
  albumArtist !: string;
  albumYear !: number;

  constructor(private dbService: DatabaseService) {}

  ngOnInit(): void {
    this.dbService.changeCurrentAlbum(this.album);
  }

  onSubmitForm(event: Event) {
    event.preventDefault();

    if (this.mode === Mode.ADD) {
      this.dbService.addAlbum(new Album(
        this.albumTitle,
        this.albumArtist,
        this.albumYear
      ));
    } else {
      this.dbService.editAlbum(new AlbumDTO(
        this.albumTitle,
        this.albumArtist,
        this.albumYear
      ));
    }
  }
}
