import { PersonalDetailsModel } from "./personal-details.model";
import {ContactDetailsModel} from "./contact-details.model";
import {EducationDetailsModel} from "./education-details.model";
import {ProfessionalDetailsModel} from "./professional-details.model";
import {ProjectModel} from "./project.model";

export class CvModel {
  personal: PersonalDetailsModel;

  contact: ContactDetailsModel;

  education: EducationDetailsModel;

  professional: ProfessionalDetailsModel;

  project: ProjectModel;
}
