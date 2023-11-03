import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'exo7';

  imageModalVisible = false;
  loginModalVisible = false;
  aboutModalVisible = false;

  onClickImage() {
    this.imageModalVisible = true;
  }

  onClickLogin() {
    this.loginModalVisible = true;
  }

  onClickAbout() {
    this.aboutModalVisible = true;
  }

  closeImageModal() {
    this.imageModalVisible = false;
  }
  
  closeLoginModal() {
    this.loginModalVisible = false;
  }
  
  closeAboutModal() {
    this.aboutModalVisible = false;
  }
}
