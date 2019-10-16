import { Account } from './../../../model/account';
import { Component, OnInit , Input } from '@angular/core';
import { InputArgs } from '@syncfusion/ej2-inputs';
import { ModalService } from 'src/app/service/modal.service';


@Component({
  selector: 'app-admin-detail',
  templateUrl: './admin-detail.component.html',
  styleUrls: ['./admin-detail.component.css']
})
export class AdminDetailComponent implements OnInit {


  adminDetail : Account;
  @Input() inputs ; 
  constructor(private modalSerive : ModalService) { }

  ngOnInit() {
    this.adminDetail = new Account();
    this.adminDetail = this.inputs;
    
  }

  closeModal(){
    this.modalSerive.destroy();
  }

}
