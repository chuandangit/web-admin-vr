import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../../../service/authentication.service';
import { from } from 'rxjs';

@Component({
  selector: 'app-side-menu',
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.css']
})
export class SideMenuComponent implements OnInit {
  role;

  constructor(private authSer:AuthenticationService) { }

  ngOnInit() {
    //this.role = this.authSer.getRole();
  }

}
