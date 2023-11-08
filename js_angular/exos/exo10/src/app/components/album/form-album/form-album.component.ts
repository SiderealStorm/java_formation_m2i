import { AfterViewInit, Component, ElementRef, EventEmitter, OnDestroy, Output, ViewChild } from '@angular/core';
import { Subscription } from 'rxjs';
import { Album } from 'src/app/models/Album.model';
import { AlbumFormMode, AlbumService } from 'src/app/services/album.service';

@Component({
  selector: 'app-form-album',
  templateUrl: './form-album.component.html',
  styleUrls: ['./form-album.component.css']
})
export class FormAlbumComponent implements AfterViewInit, OnDestroy {

  album: Album | null = null;
  albumSub: Subscription | undefined;
  
  formMode: AlbumFormMode = null;
  formModeSub: Subscription | undefined;

  @ViewChild("albumTitle") titleInputRef : ElementRef<HTMLInputElement> | undefined
  @ViewChild("albumArtist") artistInputRef : ElementRef<HTMLInputElement> | undefined
  @ViewChild("albumYear") releaseYearInputRef : ElementRef<HTMLInputElement> | undefined
  @ViewChild("albumRate") rateInputRef : ElementRef<HTMLInputElement> | undefined
  
  @Output()
  cancelEvent = new EventEmitter();

  constructor (private service: AlbumService) {
    this.albumSub = this.service.selectedAlbum$.subscribe(data => this.album = data);
    this.formModeSub = this.service.currentMode$.subscribe(data => this.formMode = data);
  }

  ngAfterViewInit(): void {
    if (this.album) {
      if (this.titleInputRef) {
        this.titleInputRef.nativeElement.value = this.album.title;
      }
      if (this.artistInputRef) {
        this.artistInputRef.nativeElement.value = this.album.artist;
      }
      if (this.releaseYearInputRef) {
        this.releaseYearInputRef.nativeElement.value = this.album.releaseYear.toString();
      }
      if (this.rateInputRef) {
        this.rateInputRef.nativeElement.value = this.album.rate.toString();
      }
    }
  }

  ngOnDestroy(): void {
    this.albumSub?.unsubscribe();
    this.formModeSub?.unsubscribe();
  }

  onSubmitForm(event : Event) {
    event.preventDefault();

    const albumValues: Album = {
      id: this.album ? this.album.id : -1,
      title: this.titleInputRef?.nativeElement.value ?? "N/A",
      artist: this.artistInputRef?.nativeElement.value ?? "N/A",
      releaseYear: +(this.releaseYearInputRef?.nativeElement.value ?? 0),
      rate: +(this.rateInputRef?.nativeElement.value ?? 0)
    }
    
    switch (this.formMode) {
      case "add" :
        this.service.addAlbum(albumValues);
        break;
      case "edit" :
        this.service.editAlbum(albumValues);
        break;
      case "delete" :
        this.service.deleteAlbum(albumValues.id);
        break;
    }

    this.service.changeFormMode(null);
  }

  onClickCancel() {
    this.cancelEvent.emit();
  }
}
