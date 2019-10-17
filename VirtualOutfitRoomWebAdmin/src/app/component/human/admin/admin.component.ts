import { ModalService } from './../../../service/modal.service';
import { Component, OnInit , Input } from '@angular/core';
import {Account} from '../../../model/account';
import { AdminDetailComponent } from '../admin-detail/admin-detail.component';
import { AccountService } from 'src/app/service/account.service';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  @Input() inputs;
  accounts ;
  
  

  constructor(private modalService : ModalService , private accountService : AccountService) { }

  ngOnInit() {
    this.accounts = new Array();
    this.showAccount();
  }

  showAccount(){
    this.accountService.getListAccounts().subscribe(result => {
      alert("Áá")
      this.accounts =  result.accountList;
    })
  }
  openAdDetail(id){
      
  }

}
