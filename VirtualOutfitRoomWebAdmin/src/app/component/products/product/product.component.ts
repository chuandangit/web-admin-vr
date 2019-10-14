import { Component, OnInit } from '@angular/core';
import { Product } from '../../../model/product';
import { ModalService } from '../../../service/modal.service';
import { from } from 'rxjs';
import { ProductCreateComponent } from '../product-create/product-create.component';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  PRODUCT : Product[] = [{id : 100,  name : "T-shirt red" , size : "S-X-XL" ,  price : 10000 , quantity : 10 , status : "disabled" , datecreated : "20-09-2019"},
  {id : 101,  name : "T-shirt yellow" , size : "S-X-XL",  price : 20000 , quantity : 10 , status : "enabled" , datecreated : "19-09-2019"}
                              ]

  constructor(private modalSer : ModalService) {  }

  ngOnInit() {
  }

  openCreate(){
      this.modalSer.init(ProductCreateComponent , [] , []);
  }

}
