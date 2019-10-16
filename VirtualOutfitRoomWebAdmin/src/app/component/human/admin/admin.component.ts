import { ModalService } from './../../../service/modal.service';
import { Component, OnInit , Input } from '@angular/core';
import {Account} from '../../../model/account';
import { AdminDetailComponent } from '../admin-detail/admin-detail.component';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  @Input() inputs;
  admin : Account;
  pos : number;
  ADMIN : Account[] = [{id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"},
  {id : 6 ,  firstname : 'admin' , lastname : 'admin' , username : 'admin' , address : '43/5 vuon lai , q12, hcm' ,status: "active" , datecreated : "10-10-2019"}

                            ]

  constructor(private modalService : ModalService) { }

  ngOnInit() {
  }

  openAdDetail(id){
      this.pos = 0;
      this.admin = this.ADMIN[0]
      this.modalService.init(AdminDetailComponent, this.admin , [])
      console.log(this.ADMIN)
  }

}
