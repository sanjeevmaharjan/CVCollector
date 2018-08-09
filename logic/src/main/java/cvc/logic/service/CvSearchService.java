package cvc.logic.service;

import cvc.domain.Cv;
import cvc.domain.PersonalDetails;
import cvc.logic.interfaces.ICvRepository;
import cvc.logic.interfaces.service.ICvSearchService;
import cvc.logic.service.specifications.PersonalDetailsSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
final class CvSearchService implements ICvSearchService {

    private final ICvRepository repository;

    public CvSearchService(ICvRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cv> minAge(short ageMin) {
        Specification<PersonalDetails> personalSpecification = PersonalDetailsSpecifications.ageGreaterThan(ageMin);
        List<Cv> searchResults = repository.findAll();
        return
    }
}
