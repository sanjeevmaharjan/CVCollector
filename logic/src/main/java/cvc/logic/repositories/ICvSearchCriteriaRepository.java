package cvc.logic.repositories;

import cvc.domain.CvSearchCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICvSearchCriteriaRepository extends JpaRepository<CvSearchCriteria,Long> {
    List<CvSearchCriteria> findByUser(long id);
}
