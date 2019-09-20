import { Component } from '@angular/core';
import { DisplayService} from './service/displayservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'VirtualOutfitRoom-WebAdmin';
  constructor(private displaySer : DisplayService){}
}
