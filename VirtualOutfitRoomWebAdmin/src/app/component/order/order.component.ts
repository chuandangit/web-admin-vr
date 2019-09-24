import { Component, OnInit } from '@angular/core';
import { Order } from '../../model/order';
import { from } from 'rxjs';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  ORDER : Order[] = [{id : 12001 , account_id : 1 , totalcost : 120000 , status : 'pending'}, 
  {id : 12002 , account_id : 2 , totalcost : 220000 , status : 'completed'},
  {id : 12003 , account_id : 4 , totalcost : 620400 , status : 'pending'},
  {id : 12004 , account_id : 2 , totalcost : 227000 , status : 'completed'},
  {id : 12005 , account_id : 5 , totalcost : 78000 , status : 'completed'}
  
                      ]

  constructor() { }

  ngOnInit() {
  }

}
