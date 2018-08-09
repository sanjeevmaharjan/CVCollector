package cvc.logic.interfaces.service;

import cvc.domain.Cv;

import java.util.List;

public interface ICvSearchService {

    List<Cv> minAge(short ageMin);

    List<Cv> maxAge(short ageMax);

}
