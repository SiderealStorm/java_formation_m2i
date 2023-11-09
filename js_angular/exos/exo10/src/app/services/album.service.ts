import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Album } from '../models/Album.model';

type AlbumFormMode = "add" | "edit" | "delete" | null;

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  albumCount = 3;

  albums$ = new BehaviorSubject<Album[]>([
    {
      id: 0,
      title: "21st Century Breakdown",
      artist: "Green Day",
      releaseYear: 2008,
      rate: 4
    },
    {
      id: 1,
      title: "The Sound of Madness",
      artist: "Shinedown",
      releaseYear: 2008,
      rate: 5
    },
    {
      id: 2,
      title: "City of Evil",
      artist: "Avanged Sevenfold",
      releaseYear: 2005,
      rate: 5
    }
  ]);
  selectedAlbum$ = new BehaviorSubject<Album | null>(null);

  currentMode$ = new BehaviorSubject<AlbumFormMode>(null);

  constructor() { }

  getAlbumById(id: number) {
    return this.albums$.getValue().find(album => album.id === id) ?? null;
  }

  addAlbum(newAlbum: Album) {
    newAlbum.id = this.albumCount++;
    this.albums$.next([...this.albums$.getValue(), newAlbum]);
  }

  editAlbum(albumValues: Album) {
    const foundAlbum = this.getAlbumById(albumValues.id);
    if (foundAlbum) {
      const newAlbum = {...albumValues};
      this.albums$.next([
        ...this.albums$.getValue().filter(album => album.id !== newAlbum.id),
        newAlbum
      ]);
    }
  }

  deleteAlbum(albumId: number) {
    this.albums$.next([...this.albums$.getValue().filter(album => album.id !== albumId)]);
  }

  changeSelectedAlbum(currentAlbum: Album | null) {
    this.selectedAlbum$.next(currentAlbum);
  }

  changeFormMode(value: AlbumFormMode) {
    this.currentMode$.next(value);
    if(value === "add") {
      this.changeSelectedAlbum(null);
    }
  }
}

export { AlbumFormMode };