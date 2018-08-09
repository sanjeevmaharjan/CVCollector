package cvc.logic.interfaces;

import cvc.domain.Cv;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICvRepository extends JpaRepository<Cv,Long>, JpaSpecificationExecutor<Cv> {
    @Override
    @Transactional(timeout = 10)
    List<Cv> findAll(Specification<Cv> spec);

    List<Cv> minAge(short ageMin);

    List<Cv> maxAge(short ageMax);
}
