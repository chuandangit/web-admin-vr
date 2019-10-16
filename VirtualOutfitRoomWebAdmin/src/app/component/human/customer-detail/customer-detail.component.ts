import { Account } from 'src/app/model/account';
import { ModalService } from './../../../service/modal.service';
import { Component, OnInit , Input } from '@angular/core';


@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  @Input() inputs ; 
  customerDetail : Account;

  constructor(private modalService : ModalService) { }

  ngOnInit() {
    this.customerDetail = new Account();
    this.customerDetail = this.inputs;

  }

  closeModal(){
      this.modalService.destroy();
  }


  changeStatus(status){
    if(status == 'active'){
      this.customerDetail.status = 'deactive'
    }else{
      this.customerDetail.status = 'active'
    }
    this.modalService.destroy();
  }

}
