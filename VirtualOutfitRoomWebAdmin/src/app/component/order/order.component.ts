import { Component, OnInit , Input } from '@angular/core';
import { Order } from '../../model/order';
import { from } from 'rxjs';
import { ModalService } from 'src/app/service/modal.service';
import { OrderDetailComponent } from './order-detail/order-detail.component';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  @Input() inputs;
  pos : number;
  order : Order;

  ORDER : Order[] = [{id : 1 , account_id : 1 , totalcost : 120000 , status : 'pending' , customer_name : "customer" , address : "q12,hcm,vn"}, 
  {id : 2 , account_id : 1 , totalcost : 220000 , status : 'completed' , customer_name: "customer" , address : "q12,hcm,vn"},
  {id : 3 , account_id : 1 , totalcost : 220000 , status : 'completed' , customer_name: "customer" , address : "q12,hcm,vn"},
  {id : 4 , account_id : 1 , totalcost : 220000 , status : 'completed' , customer_name: "customer" , address : "q12,hcm,vn"},
 
  
                      ]

  constructor(private modalService : ModalService) { }

  ngOnInit() {
  }

  openOrderDetail(id){
     this.pos = id - 1;
     this.order = this.ORDER[this.pos];
      this.modalService.init(OrderDetailComponent,  this.order , []);
  }

  removeOrder(id){
    
    this.pos = id - 1;
    this.order = this.ORDER[this.pos];
    this.order.status = "completed"
  }

}
