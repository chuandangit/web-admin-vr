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

  
  CUS : Account[] = [{id : 1 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 2 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 3 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 4 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 5 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 6 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 7 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 8 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 9 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 10 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 11 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 12 ,  firstname : 'customer' , lastname : 'customer' , username : 'customer' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  
                          ]

  constructor(private modalService : ModalService ,private accountService : AccountService ) { }

  ngOnInit() {
      

  }

  @Input() inputs;
  customer : Account;
  pos : number;

  changestatus(id) {
    this.pos = id - 1;
    this.customer = this.CUS[this.pos]
    if(this.customer.status == "active"){
      this.customer.status = "deactive";
    }else{
      this.customer.status = "active";
    }
}

openCusDetail(id){
    this.pos = id - 1;
    this.customer = this.CUS[this.pos];
    this.modalService.init(CustomerDetailComponent, this.customer , []);

}

}
