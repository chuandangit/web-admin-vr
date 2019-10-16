import { ModalService } from './../../../service/modal.service';
import { Component, OnInit , Input } from '@angular/core';


@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  @Input() inputs ; 

  constructor(private modalService : ModalService) { }

  ngOnInit() {
  }

  closeModal(){
      this.modalService.destroy();
  }



}
