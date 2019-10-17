import { Component, OnInit , Input } from '@angular/core';
import { Order } from '../../model/order';
import { from } from 'rxjs';
import { ModalService } from 'src/app/service/modal.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  @Input() inputs;
  pos : number;
  order : Order;

  ORDER : Order[] = [{id : 1 , account_id : 1 , totalcost : 120000 , status : 'pending' , customer_name : "customer"}, 
  {id : 2 , account_id : 1 , totalcost : 220000 , status : 'completed' , customer_name: "customer"},
  {id : 3 , account_id : 2 , totalcost : 620400 , status : 'pending' , customer_name: "customer"},
  {id : 4 , account_id : 2 , totalcost : 227000 , status : 'completed', customer_name: "customer"},
  
                      ]

  constructor(private modalService : ModalService) { }

  ngOnInit() {
  }

  openOrderDetail(id){
    
  }

}
