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
<<<<<<< HEAD
  accounts ;
  
  

  constructor(private modalService : ModalService , private accountService : AccountService) { }
=======
  admin : Account;
  pos : number;
  ADMIN : Account[] = [{id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"}
                            ]

  constructor(private modalService : ModalService) { }
>>>>>>> parent of 5461479... aa

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
