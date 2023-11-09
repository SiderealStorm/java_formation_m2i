import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Album } from '../models/Album.model';
import { AlbumDTO } from '../models/AlbumDTO.model';

@Injectable({
  providedIn: 'root'
})
export class DatabaseService {

  $albums = new BehaviorSubject<Album[]>([]);
  $currentAlbum = new BehaviorSubject<Album | undefined>(undefined);

  constructor() { }

  getAlbumById(id: number) {
    return this.$albums.getValue().find(album => album.id === id);
  }

  changeCurrentAlbum(album: Album | undefined) {
    this.$currentAlbum.next(album);
  }

  addAlbum(newAlbum: Album) {
    this.$albums.next([...this.$albums.getValue(), newAlbum]);
  }

  editAlbum(albumDto: AlbumDTO) {
    const album = this.$currentAlbum.getValue();
    if (album) {
      album.title = albumDto.title;
      album.artist = albumDto.artist;
      album.releaseYear = albumDto.releaseYear;
    }
  }

  deleteAlbum() {
    const album = this.$currentAlbum.getValue();
    console.log(album);
    console.log(this.$albums.getValue());
    
    
    if (album) {
      this.$albums.next(this.$albums.getValue().filter(elt => elt.id !== album.id));
    }
    console.log(this.$albums.getValue());
    
  }
}
