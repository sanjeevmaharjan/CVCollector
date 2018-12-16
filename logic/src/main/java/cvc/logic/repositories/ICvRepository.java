package cvc.logic.repositories;

import cvc.domain.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ICvRepository extends JpaRepository<Cv,Long>, JpaSpecificationExecutor<Cv> {
    Long countByUser(String username);
    Long countByLinks(Integer id);
    Long countByUserAndSubmittedTimeBetween(String username, LocalDate startDate, LocalDate endDate);
}
