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
    private ngZone: NgZone
  ) {
    this.cv = new CvModel();
    this.cv.Personal = new PersonalDetailsModel();
    this.cv.Contact = new ContactDetailsModel();
    this.cv.Education = new EducationDetailsModel();
    this.cv.Professional = new ProfessionalDetailsModel();
    this.cv.Project = new ProjectDetailsModel();
    this.cv.AdditionalInfo = new AdditionalInfoModel();

    // initialize arrays
    this.cv.Awards.push(new AwardsModel());
    this.cv.Contact.Phone.push('');
    this.cv.Contact.Email.push('');
    this.cv.Education.Institutions.push(new InstitutionModel());
    this.cv.Professional.WorkPlaces.push(new WorkplaceModel());
    this.cv.Project.Projects.push(new ProjectModel());
    this.cv.AdditionalInfo.LanguageProficiencyList.push(new LanguageProficiencyModel());
  }

  ngOnInit() {
  }

  public beforeChange($event: NgbTabChangeEvent) {
  };

  public addPhone() {
    this.cv.Contact.Phone.push('');
  }

  public addEmail() {
    this.cv.Contact.Email.push('');
  }

  public addInstitution() {
    this.cv.Education.Institutions.push(new InstitutionModel());
  }

  public addWorkplace() {
    this.cv.Professional.WorkPlaces.push(new WorkplaceModel());
  }

  public addProject() {
    this.cv.Project.Projects.push(new ProjectModel());
  }

  public addLanguageProficiency() {
    this.cv.AdditionalInfo.LanguageProficiencyList.push(new LanguageProficiencyModel());
  }

  public save() {
    console.log(this.cv);
  }
}
