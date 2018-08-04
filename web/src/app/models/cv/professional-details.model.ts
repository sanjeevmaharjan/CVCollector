import {WorkplaceModel} from "./workplace.model";

export class ProfessionalDetailsModel {
  professionalSkills: string;

  workPlaces: WorkplaceModel[] = [];
  additionalDetails: string;
}
