package cvc.logic.repositories;

import cvc.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRoleRepository extends JpaRepository<Roles, Long>, JpaSpecificationExecutor<Roles> {
}
