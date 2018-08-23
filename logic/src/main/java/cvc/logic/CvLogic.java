package cvc.logic;

import cvc.logic.repositories.ICvRepository;

public class CvLogic {
    private ICvRepository cvRepository;

    public CvLogic(ICvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    /*public List<Cv> getBySmartFilter() {
        List<Cv> cvList = cvRepository.findAll();


    }*/
}
