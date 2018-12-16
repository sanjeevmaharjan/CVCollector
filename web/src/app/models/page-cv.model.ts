import {CvModel} from "./cv/cv.model";

export class PageCvModel {
  content: CvModel[];
  pageable: any;
  last: boolean;
  totalElements: number;
  totalPages: number;
  number: number;
  size: number;
  sort: any;
  numberOfElements: number;
  first: boolean;
  empty: boolean;
}
