import {PersonalDetailsModel} from './personal-details.model';
import {ContactDetailsModel} from './contact-details.model';
import {EducationDetailsModel} from './education-details.model';
import {ProfessionalDetailsModel} from './professional-details.model';
import {AdditionalInfoModel} from './additional-info.model';
import {ProjectDetailsModel} from './project-details.model';
import {AwardsModel} from './awards.model';

export class CvModel {
  id: number;

  links: number;

  personal: PersonalDetailsModel;

  contact: ContactDetailsModel;

  education: EducationDetailsModel;

  professional: ProfessionalDetailsModel;

  project: ProjectDetailsModel;

  additionalInfo: AdditionalInfoModel;

  awards: AwardsModel[] = [];
}
