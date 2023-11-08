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

    console.log(this.album);
    const albumValues: Album = {
      id: -1,
      title: this.titleInputRef?.nativeElement.value ?? "N/A",
      artist: this.artistInputRef?.nativeElement.value ?? "N/A",
      releaseYear: +(this.releaseYearInputRef?.nativeElement.value ?? 0),
      rate: +(this.artistInputRef?.nativeElement.value ?? 0)
    }
    
    
    if (this.album) {
      switch (this.formMode) {
        case "add" :
          this.service.addAlbum(this.album);
          break;
        case "edit" :
          this.service.editAlbum(this.album);
          break;
        case "delete" :
          this.service.deleteAlbum(this.album.id);
          break;
      }
    }

    this.service.changeFormMode(null);
  }

  onClickCancel() {
    this.cancelEvent.emit();
  }
}
