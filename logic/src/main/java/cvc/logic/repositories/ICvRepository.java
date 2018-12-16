package cvc.logic.repositories;

import cvc.domain.Cv;
import cvc.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ICvRepository extends PagingAndSortingRepository<Cv,Long>, JpaSpecificationExecutor<Cv> {
    Long countByUser(String username);
    Long countByLinks(Integer id);
    Long countByUserAndSubmittedTimeBetween(String username, LocalDate startDate, LocalDate endDate);
    Page<Cv> findByLink(Long id, Pageable pageable);
}
