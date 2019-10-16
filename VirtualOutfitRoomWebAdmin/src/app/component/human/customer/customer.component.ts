import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/model/account';
im


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  CUSTOMER : Account[] = [{id : 1, firstname : 'anh' , lastname : 'nguyen' , username : 'mrtest1' , address : '43/5 vuon lai , q12, hcm' , status: 'active'},
  {id : 2, firstname : 'binh' , lastname : 'luu' , username : 'mrtest2' , address : '43/5 an hiep  , q12, hcm', status: 'active'},
  {id : 3, firstname : 'chi' , lastname : 'le' , username : 'mrtest2' , address : '321 quang trung , go vap, hcm' , status : 'active'}
                            ]

  constructor() { }

  ngOnInit() {
  }

  openCusdetail(){
      
  }

}
