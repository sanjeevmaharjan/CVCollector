package cvc.logic.services.interfaces;

import client.entities.Dashboard;
import cvc.domain.Cv;
import cvc.domain.Users;
import cvc.logic.model.CvSearchCriteriaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICvSearchService {

    List<Cv> withName(String name);

    List<Cv> withGender(short gender);

    List<Cv> minAge(short ageMin);

    List<Cv> maxAge(short ageMax);

    Cv getById(long id);

    List<Cv> findByFilter(CvSearchCriteriaModel cvSearchCriteria);

    List<Cv> findUsersCv();

    Dashboard getDashboardStats();
}
