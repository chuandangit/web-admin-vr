import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/model/category';
import { SubCategory } from 'src/app/model/subcategory';
import { ModalService } from 'src/app/service/modal.service';
import { CategoryCreateComponent } from '../category-create/category-create.component';



@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  sub : Array<SubCategory>;
  subcategory : SubCategory;
  CATEGORY : Category[];
  constructor(private modalSerive : ModalService) { }

  ngOnInit() {
    this.sub = new Array();
    this.subcategory = new SubCategory();
    this.sub.push({name : "Kính mát"});
    this.sub.push({name : "Kính râm"});

    this.CATEGORY = [{id:1 , name : 'Kính' , description : 'Kính là thời trang được ưa thích nhất hiện nay' , subcategory : this.sub ,status: 'active' }]

    console.log(this.CATEGORY)

  }

  openCreate(){
      this.modalSerive.init(CategoryCreateComponent , [] , []);
  }

}
