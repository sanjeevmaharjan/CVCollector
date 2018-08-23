package cvc.logic.repositories;

import cvc.domain.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ICvRepository extends JpaRepository<Cv,Long>, JpaSpecificationExecutor<Cv> {
}
