import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientJsonpModule } from '@angular/common/http';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ComponentsRoutes } from './component.routing';
import { NgbdpregressbarBasic } from './progressbar/progressbar.component';
import { NgbdpaginationBasic } from './pagination/pagination.component';
import { NgbdAccordionBasic } from './accordion/accordion.component';
import { NgbdAlertBasic } from './alert/alert.component';
import { NgbdCarouselBasic } from './carousel/carousel.component';
import { NgbdDatepickerBasic } from './datepicker/datepicker.component';
import { NgbdDropdownBasic } from './dropdown-collapse/dropdown-collapse.component';
import { NgbdModalBasic } from './modal/modal.component';
import { NgbdPopTooltip } from './popover-tooltip/popover-tooltip.component';
import { NgbdratingBasic } from './rating/rating.component';
import { NgbdtabsBasic } from './tabs/tabs.component';
import { NgbdtimepickerBasic } from './timepicker/timepicker.component';
import { NgbdtypeheadBasic } from './typehead/typehead.component';
import { CardsComponent } from './card/card.component';
import { ButtonsComponent } from './buttons/buttons.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CvTodayComponent } from './cv-today/cv-today.component';
import { CvWeekComponent } from './cv-week/cv-week.component';
import { CvIndividualComponent } from './cv-individual/cv-individual.component';
import { CvListComponent } from './cv-list/cv-list.component';
import { CvGridComponent } from './cv-grid/cv-grid.component';
import {CvViewComponent} from '../shared/cv-view/cv-view.component';
import {SpinnerComponent} from "./spinner.component";
import { SearchComponent } from './search/search.component';
import { LinksComponent } from './links/links.component';
import { ViewLinkComponent } from './view-link/view-link.component';
import { CreateLinkComponent } from './create-link/create-link.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(ComponentsRoutes),
    FormsModule,
    ReactiveFormsModule,
    HttpClientJsonpModule,
    NgbModule
  ],
  declarations: [
    NgbdpregressbarBasic,
    NgbdpaginationBasic,
    NgbdAccordionBasic,
    NgbdAlertBasic,
    NgbdCarouselBasic,
    NgbdDatepickerBasic,
    NgbdDropdownBasic,
    NgbdModalBasic,
    NgbdPopTooltip,
    NgbdratingBasic,
    NgbdtabsBasic,
    NgbdtimepickerBasic,
    NgbdtypeheadBasic,
    CardsComponent,
    ButtonsComponent,
    DashboardComponent,
    CvTodayComponent,
    CvWeekComponent,
    CvIndividualComponent,
    CvListComponent,
    CvGridComponent,
    CvViewComponent,
    SpinnerComponent,
    SearchComponent,
    LinksComponent,
    ViewLinkComponent,
    CreateLinkComponent
  ]
})

export class ComponentsModule {}
