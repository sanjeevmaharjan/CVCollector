package cvc.logic.interfaces.service;

import cvc.domain.Cv;
import cvc.logic.model.CvSearchCriteria;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ICvSearchService {

    List<Cv> nameStartsWith(String string);

    List<Cv> minAge(short ageMin);

    List<Cv> maxAge(short ageMax);

    List<Cv> getAll();

    Cv getById(long id);

    List<Cv> findByFilter(CvSearchCriteria cvSearchCriteria);

}
