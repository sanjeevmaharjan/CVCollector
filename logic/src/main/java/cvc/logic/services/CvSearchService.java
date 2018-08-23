package cvc.logic.services;

import cvc.domain.Cv;
import cvc.logic.repositories.ICvRepository;
import cvc.logic.services.interfaces.ICvSearchService;
import cvc.logic.model.CvSearchCriteria;
import cvc.logic.specifications.PersonalDetailsSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Cv> nameStartsWith(String startsWith) {
        Specification<Cv> specs = PersonalDetailsSpecifications.nameStartsWith(startsWith);
        List<Cv> searchResults = repository.findAll(specs);
        return searchResults;
    }

    @Override
    public List<Cv> findByFilter(CvSearchCriteria cvSearchCriteria) {
        if (cvSearchCriteria == null) {
            return repository.findAll();
        }

        Specification<Cv> specs = cvSearchCriteria.getSpecs();
        List<Cv> searchResults = repository.findAll(specs);
        return searchResults;
    }
}
