package cvc.logic.interfaces.service;

import cvc.domain.Cv;
import cvc.logic.model.CvSearchCriteria;

import java.util.List;

public interface ICvSearchService {

    List<Cv> nameStartsWith(String string);

    List<Cv> minAge(short ageMin);

    List<Cv> maxAge(short ageMax);

    List<Cv> findByFilter(CvSearchCriteria cvSearchCriteria);

}
