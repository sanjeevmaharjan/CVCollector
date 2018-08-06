import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { CvComponent } from './cv/cv.component';
import {GuestRoutes} from "./guest.routing";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {TextDirective} from "../shared/form-elements/text.directive";
import {FormsModule} from "@angular/forms";
import {PreviewComponent} from "./preview/preview.component";
import {HomeComponent} from "./home/home.component";
import {CvViewComponent} from "../shared/cv-view/cv-view.component";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(GuestRoutes),
    NgbModule,
    FormsModule
  ],
  declarations: [
    LoginComponent,
    SignupComponent,
    CvComponent,
    TextDirective,
    PreviewComponent,
    HomeComponent,
    CvViewComponent
  ]
})
export class GuestModule { }
