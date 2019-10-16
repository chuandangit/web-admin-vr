import { Component, OnInit } from '@angular/core';
import { ModalService } from 'src/app/service/modal.service';


@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {

  constructor(private modalSerivce : ModalService) { }

  ngOnInit() {
  }

  closeModal(){
      this.modalSerivce.destroy();
  }

}
