import {Role} from './role'
import { Workplace } from './workplace';
import {Location} from './location';
import {Team} from './team';
import { from } from 'rxjs';
export class Account {
    id : number;
    firstname : string;
    lastname : string;
    email : string;
    address : string;
    phone : string;
    username : string;
    password : string;
    datecreated : Date;
    datemodified : Date;
    isActived: boolean;
    isDeleted : boolean;
    roleId : number;

}
