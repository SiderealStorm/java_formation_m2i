import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Album } from 'src/app/models/Album.model';
import { DatabaseService } from 'src/app/services/database.service';

@Component({
  selector: 'app-album-card',
  templateUrl: './album-card.component.html',
  styleUrls: ['./album-card.component.css']
})
export class AlbumCardComponent implements OnInit {

  @Input({
    required: true
  })
  albumId!: number;

  album: Album | undefined;

  @Output()
  editEvent = new EventEmitter<number>();
  @Output()
  deleteEvent = new EventEmitter<number>();

  constructor(private dbService: DatabaseService) {}

  ngOnInit(): void {
    this.album = this.dbService.getAlbumById(this.albumId);
    this.dbService.changeCurrentAlbum(this.album);
  }

  onClickEdit() {
    this.editEvent.emit(this.albumId);
  }

  onClickDelete() {
    this.deleteEvent.emit(this.albumId);
  }
}
