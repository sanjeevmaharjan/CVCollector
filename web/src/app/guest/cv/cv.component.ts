import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';
import {NgbAccordion, NgbAccordionConfig, NgbPanelChangeEvent, NgbTabChangeEvent} from '@ng-bootstrap/ng-bootstrap';
//import {AgmCoreModule, MapsAPILoader} from "@agm/core";
import { } from 'googlemaps';
import {FormControl} from "@angular/forms";
import { CvModel } from '../../models/cv/cv.model';
import {PersonalDetailsModel} from "../../models/cv/personal-details.model";
import {ContactDetailsModel} from "../../models/cv/contact-details.model";
import {EducationDetailsModel} from "../../models/cv/education-details.model";
import {ProfessionalDetailsModel} from "../../models/cv/professional-details.model";
import {ProjectModel} from "../../models/cv/project.model";
import {AdditionalInfoModel} from "../../models/cv/additional-info.model";
import {InstitutionModel} from "../../models/cv/institution.model";
import {WorkplaceModel} from "../../models/cv/workplace.model";
import {ProjectDetailsModel} from "../../models/cv/project-details.model";
import {AwardsModel} from "../../models/cv/awards.model";
import {LanguageProficiencyModel} from "../../models/cv/language-proficiency.model";
import {HttpService} from "../../services/http.service";

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {
  cv: CvModel;

  minDate: Date = new Date(1);

  currentDate: Date = new Date(Date.now());

  constructor(
    private httpService: HttpService,
    private ngZone: NgZone
  ) {
    this.cv = new CvModel();
    this.cv.personal = new PersonalDetailsModel();
    this.cv.contact = new ContactDetailsModel();
    this.cv.education = new EducationDetailsModel();
    this.cv.professional = new ProfessionalDetailsModel();
    this.cv.project = new ProjectDetailsModel();
    this.cv.additionalInfo = new AdditionalInfoModel();

    // initialize arrays
    this.cv.awards.push(new AwardsModel());
    this.cv.contact.phone.push('');
    this.cv.contact.email.push('');
    this.cv.education.institutions.push(new InstitutionModel());
    this.cv.professional.workPlaces.push(new WorkplaceModel());
    this.cv.project.projects.push(new ProjectModel());
    this.cv.additionalInfo.languageProficiencyList.push(new LanguageProficiencyModel());
  }

  ngOnInit() {
  }

  public beforeChange($event: NgbTabChangeEvent) {
  };

  public addPhone() {
    this.cv.contact.phone.push('');
  }

  public addEmail() {
    this.cv.contact.email.push('');
  }

  public addInstitution() {
    this.cv.education.institutions.push(new InstitutionModel());
  }

  public addWorkplace() {
    this.cv.professional.workPlaces.push(new WorkplaceModel());
  }

  public addProject() {
    this.cv.project.projects.push(new ProjectModel());
  }

  public addLanguageProficiency() {
    this.cv.additionalInfo.languageProficiencyList.push(new LanguageProficiencyModel());
  }

  public save() {
    console.log(this.cv);
    this.httpService.postAsJson<CvModel>("cv/add", this.cv)
      .subscribe(msg => console.log(msg));
  }
}
