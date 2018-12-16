import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';
import {
  NgbAccordion,
  NgbAccordionConfig,
  NgbDateParserFormatter,
  NgbPanelChangeEvent,
  NgbTabChangeEvent
} from '@ng-bootstrap/ng-bootstrap';
// import {AgmCoreModule, MapsAPILoader} from "@agm/core";
// import { } from 'googlemaps';
import {FormControl} from '@angular/forms';
import {CvModel} from '../../models/cv/cv.model';
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
import {ActivatedRoute} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {
  cv: CvModel;

  isLinkValid: boolean;

  minDate: Date = new Date(1);
  private link: number;

  currentDate: Date = new Date(Date.now());

  constructor(
    private httpService: HttpService,
    route: ActivatedRoute,
    private toastr: ToastrService,
    private dateParser: NgbDateParserFormatter
  ) {

    const link = route.snapshot.params['link'];

    this.link = typeof link === 'string' ? parseInt(link, 10) : this.link;

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
      const cv = JSON.parse(cvFromLocal);
      this.cv = cv;
      this.cv.links = this.link;
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

  public autoSave(): void {
    this.toastr.success('AutoSaved!');
    this.cv.links = this.link;
    console.log(this.cv);
    localStorage.setItem('cv-data', JSON.stringify(this.cv));
  }

  public save() {
    console.log(this.cv);
    const cvFromLocal = localStorage.getItem('cv-data');
    this.cv.links = this.link;

    if (!isNullOrUndefined(cvFromLocal)) {
      const cv = JSON.parse(cvFromLocal);

      this.cv.personal.dateOfBirth = this.dateParser.format(cv.personal.dateOfBirth);
      this.cv.education.institutions.forEach((value, index) => {
        value.suruDate = this.dateParser.format(cv.education.institutions[index].suruDate);
        value.antimDate = this.dateParser.format(cv.education.institutions[index].antimDate);
      });
    }

    localStorage.setItem('cv-data', JSON.stringify(this.cv));
    this.httpService.postAsJson<CvModel>('/api/cv/add/' + this.link, this.cv)
      .subscribe(msg => console.log(msg));
  }
}

