import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./component/other/header/header.component";
import { FormsModule } from "@angular/forms";
import { AppRoutingModule } from "./app-routing.module";
import { NotFoundComponent } from "./component/other/not-found/not-found.component";
import { SideMenuComponent } from "./component/other/side-menu/side-menu.component";
import { HomeComponent } from "./component/other/home/home.component";
import { ChartsModule } from "ng2-charts";
import { GoogleChartsModule } from "angular-google-charts";
import { DateRangePickerModule } from "@syncfusion/ej2-angular-calendars";
import { ScrollingModule } from "@angular/cdk/scrolling";
import { AgmCoreModule } from "@agm/core";
import { DatePipe } from "@angular/common";
import { CKEditorModule } from "@ckeditor/ckeditor5-angular";
import { TagCloudModule } from "angular-tag-cloud-module";
import { NgxChartsModule } from "@swimlane/ngx-charts";
import { AuthHomeComponent } from "./component/auth-home/auth-home.component";
import { TutorialComponent } from './component/other/tutorial/tutorial.component';
import { from } from 'rxjs';
import { DialogComponent } from './component/other/dialog/dialog.component';
import {MatCheckboxModule, MatTableModule, MatPaginatorModule, MatSortModule} from '@angular/material';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { CategoryComponent } from './component/category/category.component';
import { ProductComponent } from './component/product/product.component';
import { OrderComponent } from './component/order/order.component';
import { CustomerComponent } from './component/customer/customer.component';
import { AdminComponent } from './component/admin/admin.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent, 
    NotFoundComponent,
    SideMenuComponent,
    HomeComponent,
    AuthHomeComponent, 
    TutorialComponent,
    DialogComponent, 
    DashboardComponent,
    CategoryComponent,
    ProductComponent,  
    OrderComponent,
    CustomerComponent,
    AdminComponent,

  
    
    

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatCheckboxModule,
    FormsModule,
    AppRoutingModule,
    ScrollingModule,
    DateRangePickerModule,
    CKEditorModule,
    ChartsModule,
    GoogleChartsModule,
    TagCloudModule,
    NgxChartsModule,
    BrowserAnimationsModule,
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyCdlgyq8ejq83BTKNpz2q2m1PrLp3D20JY",
      libraries: ["places"]
    }),
    MatTableModule,
    MatPaginatorModule,
    MatSortModule
  ],
  entryComponents: [
    DialogComponent,
  ],

  // providers: [
  //   {
  //     provide: HTTP_INTERCEPTORS,
  //     useClass: TokenInterceptor,
  //     multi: true
  //   },
  //   [DatePipe]
  // ],
  bootstrap: [AppComponent]
})
export class AppModule {}
