import { ModalService } from './../../../service/modal.service';
import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/model/account';
import { CustomerDetailComponent } from '../customer-detail/customer-detail.component';
import { AccountService } from 'src/app/service/account.service';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  accounts;

  constructor(private modalService : ModalService ,private accountService : AccountService ) { }

  ngOnInit() {
      this.accounts = new Array();

  }

  showAccounts(){
      this.accountService.getListAccounts().subscribe(result => {
        this.accounts = result.accountList;
      })
  }

  openCusdetail(item){
     
  }

}
