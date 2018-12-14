package cvc.logic.repositories.Impl;

import client.entities.Dashboard;
import cvc.logic.repositories.ICvExtended;
import cvc.logic.repositories.ICvRepository;
import cvc.logic.specifications.DashBoardSpecifications;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CvExtendedImpl implements ICvExtended {
    private final ICvRepository repository;

    public CvExtendedImpl(ICvRepository cvRepository) {
        this.repository = cvRepository;
    }
    @Override
    public Dashboard dashboardStats(Long id) {

        Long numCvs = (long) repository.findAll(DashBoardSpecifications.NumCvs((long) 1)).size();
        Long numCvsToday = (long) repository.findAll(DashBoardSpecifications.NumCvsToday((long) 1)).size();
        Long numCvsWeek = (long) repository.findAll(DashBoardSpecifications.NumCvsThisWeek((long) 1)).size();

        return new Dashboard()
                .setNumCvs(numCvs)
                .setSubmittedToday(numCvsToday)
                .setSubmittedThisWeek(numCvsWeek);
    }
}
