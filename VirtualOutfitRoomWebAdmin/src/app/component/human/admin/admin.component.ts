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
  admin : Account;
  pos : number;
  ADMIN : Account[] = [{id : 1 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 2 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"}, 
  {id : 3 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 4 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 5 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 7 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 8 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 9 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 10 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"},
  {id : 11 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active"}


]

  constructor(private modalService : ModalService) { }

  ngOnInit() {
    
   
  }

  changestatus(id) {
      this.pos = id - 1;
      this.admin = this.ADMIN[this.pos]
      if(this.admin.status == "active"){
        this.admin.status = "deactive";
      }else{
        this.admin.status = "active";
      }
  }

  openAdDetail(id){
      this.pos = id - 1;
      this.admin = this.ADMIN[this.pos];
      this.modalService.init(AdminDetailComponent, this.admin , []);

  }

}
