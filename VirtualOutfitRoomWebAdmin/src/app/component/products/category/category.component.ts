import { Component, OnInit, Output, Input } from '@angular/core';
import { ModalService } from 'src/app/service/modal.service';
import { CategoryCreateComponent } from '../category-create/category-create.component';
import { Category } from 'src/app/model/category';
import { SubCategory } from 'src/app/model/subcategory';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  @Output() out;

  constructor(private modalService : ModalService) { }
  sub : Array<SubCategory> = [{id : 1, name : "kinh mat"} , {id: 2, name : "kinh ram"}]
  CATEGORY : Category[] = [{id : 1 ,description : "Mat kinh la thoi trang duoc ua thich hien nay" , name : "Kinh" , subcategory: this.sub }]
  

  ngOnInit() {
      if(this.out != null){
        this.CATEGORY.push(this.out)
      }
      
    
  }
  
  openCreate(){
        this.modalService.init(CategoryCreateComponent, [] , this.out )
  }

}