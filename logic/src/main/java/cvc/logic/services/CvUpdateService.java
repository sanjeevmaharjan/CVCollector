package cvc.logic.services;

import cvc.domain.Cv;
import cvc.logic.repositories.ICvRepository;
import cvc.logic.services.interfaces.ICvUpdateService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CvUpdateService implements ICvUpdateService {

    private ICvRepository repository;

    public CvUpdateService(ICvRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Cv cv) {
        cv.setSubmittedTime(LocalDate.now());
        repository.save(cv);
    }

    @Override
    public void update(Cv cv) {
        repository.save(cv);
    }
}
