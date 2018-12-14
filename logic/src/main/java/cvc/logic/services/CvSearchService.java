package cvc.logic.services;

import client.entities.Dashboard;
import cvc.domain.Cv;
import cvc.logic.repositories.ICvRepository;
import cvc.logic.services.interfaces.ICvSearchService;
import cvc.logic.model.CvSearchCriteriaModel;
import cvc.logic.specifications.PersonalDetailsSpecifications;
import enums.Genders;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CvSearchService implements ICvSearchService {

    private final ICvRepository repository;

    public CvSearchService(ICvRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cv> minAge(short ageMin) {
        Specification<Cv> specs = PersonalDetailsSpecifications.ageGreaterThan(ageMin);
        List<Cv> searchResults = repository.findAll(specs);
        return searchResults;
    }

    @Override
    public List<Cv> maxAge(short ageMax) {
        Specification<Cv> specs = PersonalDetailsSpecifications.ageLessThan(ageMax);
        List<Cv> searchResults = repository.findAll(specs);
        return searchResults;
    }

    @Override
    public List<Cv> getAll() {
        return repository.findAll();
    }

    @Override
    public Cv getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cv> withName(String name) {
        Specification<Cv> specs = PersonalDetailsSpecifications.nameStartsWith(name);
        List<Cv> searchResults = repository.findAll(specs);
        return searchResults;
    }

    @Override
    public List<Cv> withGender(short gender) {
        Specification<Cv> specs = PersonalDetailsSpecifications.thisGenderOnly(Genders.fromId(gender));
        return repository.findAll(specs);
    }

    @Override
    public List<Cv> findByFilter(CvSearchCriteriaModel criteriaModel) {
        if (criteriaModel == null) {
            return repository.findAll();
        }

        Specification<Cv> specs = criteriaModel.getSpecs();
        List<Cv> searchResults = repository.findAll(specs);
        return searchResults;
    }

    @Override
    public Dashboard getDashboardStats() {
        final long id = 1;
        final LocalDate today = LocalDate.now();
        final LocalDate yesterday = today.minusDays(1);
        final LocalDate lastWeek = today.minusDays(7);

        long numCvs = repository.countByUser(id);
        long numCvsToday = repository.countByUserAndSubmittedTimeBetween(id, yesterday, today);
        long numCvsThisWeek = repository.countByUserAndSubmittedTimeBetween(id, lastWeek, today);

        return new Dashboard().setNumCvs(numCvs)
                .setSubmittedToday(numCvsToday)
                .setSubmittedThisWeek(numCvsThisWeek);
    }


}
