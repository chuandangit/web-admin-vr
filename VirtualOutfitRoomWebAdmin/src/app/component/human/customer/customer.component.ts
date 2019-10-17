import { ModalService } from './../../../service/modal.service';
import { Component, OnInit , Input} from '@angular/core';
import { Account } from 'src/app/model/account';
import { CustomerDetailComponent } from '../customer-detail/customer-detail.component';
import { AccountService } from 'src/app/service/account.service';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  
  CUSTOMER : Account[] = [
]

  constructor(private modalService : ModalService ,private accountService : AccountService ) { }

  ngOnInit() {
      

  }

  @Input() inputs;
  admin : Account;
  pos : number;

  changestatus(id) {
    this.pos = id - 1;
    this.admin = this.CUSTOMER[this.pos]
    if(this.admin.status == "active"){
      this.admin.status = "deactive";
    }else{
      this.admin.status = "active";
    }
}

openAdDetail(id){
    this.pos = id - 1;
    this.admin = this.CUSTOMER[this.pos];
    this.modalService.init(CustomerDetailComponent, this.admin , []);

}

}
