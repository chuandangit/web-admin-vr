import { SubCategory } from './subcategory';

SubCategory
export class Category {
  id:Number;
  name:string;
  description:string;
  subcategory : Array<SubCategory>;
  status : string;
}
