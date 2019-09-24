import { Component, OnInit } from '@angular/core';
import { Product } from '../../model/product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  PRODUCT : Product[] = [{id : 100,  name : "T-shirt red" , price : 10000 , quantity : 10 , status : "disabled"},
  {id : 101,  name : "T-shirt yellow" , price : 20000 , quantity : 10 , status : "enabled"}
                              ]

  constructor() { }

  ngOnInit() {
  }

}
