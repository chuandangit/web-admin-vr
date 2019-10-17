import { Component, OnInit } from '@angular/core';
import { ModalService } from 'src/app/service/modal.service';
import { Output } from '@angular/core';
import { Category } from 'src/app/model/category';


@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {

  @Output() outputs;
  categoryName : string;
  subname : string;
  description : string;

  categoryNew : Category;
  displaySub : Array<string>;
  displaySubId : Array<number>;

  constructor(private modalService : ModalService) { }

  ngOnInit() {
    this.categoryNew = new Category();
    this.categoryName = "";
    this.subname = "";
    this.displaySub = new Array();
    this.displaySubId = new Array();

  }
  addCategory(category, des){
      this.categoryName = category;
      this.description = des;
      this.categoryNew.name = this.categoryName;
      this.categoryNew.id = 2;
      this.categoryNew.description = this.description;
      
      this.outputs = this.categoryNew;
      console.log(this.outputs)
      
  }

  addnewSub(name){
      this.subname = name;
      this.displaySub.forEach(element => {
        if(element == this.subname){
          alert("Existed subcategory")
          
          return;
        }
      })
      this.displaySub.push(this.subname);
      this.displaySubId.push(2);
      this.subname = " ";

  }

  removeSub(index) {

    this.displaySub.splice(index , 1);

  }

  closeModal(){
      this.modalService.destroy();
  }


}
