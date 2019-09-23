
import { AuthGuard } from "./guard/auth.guard";
import { AuthHomeComponent } from "./component/auth-home/auth-home.component";

import { HomeComponent } from "./component/other/home/home.component";


import { RouterModule, Routes } from "@angular/router";
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { NotFoundComponent } from "./component/other/not-found/not-found.component";

import { from } from 'rxjs';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { CategoryComponent } from './component/category/category.component';
import { ProductComponent } from './component/product/product.component';
import { OrderComponent } from './component/order/order.component';
import { CustomerComponent } from './component/customer/customer.component';
import { AdminComponent } from './component/admin/admin.component';
import { DataTableComponent } from './component/other/data-table/data-table.component';


const authRoutes: Routes = [
  {path : "dashboard" , component : DashboardComponent},
  {path : "category" , component : CategoryComponent },
  {path : "product", component : ProductComponent}, 
  {path : "order" , component : OrderComponent},
  {path : "customer" , component : CustomerComponent},
  {path : "admin" , component : AdminComponent},
    
];

const routes: Routes = [
  { path: "home", component: HomeComponent },
  // { path: "register", component: RegisterComponent },
  // { path: "404", component: NotFoundComponent },
  // { path: "change-password/:emailToken", component: ResetPasswordComponent},
  // { path: "forget", component: ForgetPasswordComponent },
  // { path: "login", component: LoginComponent },
  // { path: "join/:token", component: JoinComponent },
  // { path: "take/:token", component: SurveyTakeComponent },
  // { path: "confirm/:accountToken", component: RegisterConfirmComponent },
  {
    path: "",
    component: AuthHomeComponent,
    canActivate: [AuthGuard],
    canActivateChild: [AuthGuard],
    children: authRoutes
  },
  { path: "**", redirectTo: "404" }
];

@NgModule({
  declarations: [],
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
