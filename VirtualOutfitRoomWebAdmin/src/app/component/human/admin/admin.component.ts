import { Component, OnInit } from '@angular/core';
import {Account} from '../../../model/account';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  ADMIN : Account[] = [{id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm'}
                            ]

  constructor() { }

  ngOnInit() {
  }

}
