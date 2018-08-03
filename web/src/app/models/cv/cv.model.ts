import { PersonalDetailsModel } from "./personal-details.model";
import {ContactDetailsModel} from "./contact-details.model";
import {EducationDetailsModel} from "./education-details.model";
import {ProfessionalDetailsModel} from "./professional-details.model";
import {AdditionalInfoModel} from "./additional-info.model";
import {ProjectDetailsModel} from "./project-details.model";
import {AwardsModel} from "./awards.model";

export class CvModel {
  Personal: PersonalDetailsModel;

  Contact: ContactDetailsModel;

  Education: EducationDetailsModel;

  Professional: ProfessionalDetailsModel;

  Project: ProjectDetailsModel;

  AdditionalInfo: AdditionalInfoModel;

  Awards: AwardsModel[] = [];
}
