package cvc.logic.interfaces;

import cvc.domain.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ICvRepository extends JpaRepository<Cv,Long> {

}
