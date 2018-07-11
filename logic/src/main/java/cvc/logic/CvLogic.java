package cvc.logic;

import cvc.domain.Cv;
import cvc.logic.interfaces.ICvRepository;

import java.util.List;

public class CvLogic {
    private ICvRepository cvRepository;

    public CvLogic(ICvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    public List<Cv> getBySmartFilter() {
        List<Cv> cvList = cvRepository.findAll();


    }
}
