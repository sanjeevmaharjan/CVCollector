import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';
import {NgbAccordion, NgbAccordionConfig, NgbPanelChangeEvent, NgbTabChangeEvent} from '@ng-bootstrap/ng-bootstrap';
// import {AgmCoreModule, MapsAPILoader} from "@agm/core";
// import { } from 'googlemaps';
import {FormControl} from '@angular/forms';
import { CvModel } from '../../models/cv/cv.model';
import {PersonalDetailsModel} from '../../models/cv/personal-details.model';
import {ContactDetailsModel} from '../../models/cv/contact-details.model';
import {EducationDetailsModel} from '../../models/cv/education-details.model';
import {ProfessionalDetailsModel} from '../../models/cv/professional-details.model';
import {ProjectModel} from '../../models/cv/project.model';
import {AdditionalInfoModel} from '../../models/cv/additional-info.model';
import {InstitutionModel} from '../../models/cv/institution.model';
import {WorkplaceModel} from '../../models/cv/workplace.model';
import {ProjectDetailsModel} from '../../models/cv/project-details.model';
import {AwardsModel} from '../../models/cv/awards.model';
import {LanguageProficiencyModel} from '../../models/cv/language-proficiency.model';
import {HttpService} from '../../services/http.service';
import {isNullOrUndefined} from '@swimlane/ngx-datatable/release/utils';
import {MapsAPILoader} from '@agm/core';

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
    private httpService: HttpService
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
    const cvFromLocal = localStorage.getItem('cv-data');
    if (!isNullOrUndefined(cvFromLocal)) {
      this.cv = JSON.parse(cvFromLocal);
    }
  }

  public beforeChange($event: NgbTabChangeEvent) {
    localStorage.setItem('cv-data', JSON.stringify(this.cv));
    console.log(this.cv);
  }

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
    localStorage.setItem('cv-data', JSON.stringify(this.cv));
    this.httpService.postAsJson<CvModel>('cv/add', this.cv)
      .subscribe(msg => console.log(msg));
  }
}

