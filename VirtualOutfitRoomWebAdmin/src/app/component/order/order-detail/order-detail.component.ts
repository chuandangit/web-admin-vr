import { Component, OnInit , Input } from '@angular/core';
import { ModalService } from 'src/app/service/modal.service';
import { Order } from 'src/app/model/order';

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.css']
})
export class OrderDetailComponent implements OnInit {

  @Input() inputs;
  orderDetail : Order;

  constructor(private modalService : ModalService) { }

  ngOnInit() {
    this.orderDetail = new Order();
    this.orderDetail = this.inputs;
  }

  closeModal(){
    this.modalService.destroy();
  }

}
