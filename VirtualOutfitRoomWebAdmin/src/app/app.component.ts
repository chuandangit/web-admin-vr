import { AuthenticationService } from './service/authentication.service';
import { Component } from '@angular/core';
import { DisplayService } from './service/display.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'VirtualOutfitRoom';

  constructor(private authSer:AuthenticationService, private displaySer:DisplayService) {}
}
