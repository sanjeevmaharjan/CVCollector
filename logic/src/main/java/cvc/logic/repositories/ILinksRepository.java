package cvc.logic.repositories;

import cvc.domain.Links;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILinksRepository extends JpaRepository<Links, Long> {
    List<Links> findByUser(String user);
}
