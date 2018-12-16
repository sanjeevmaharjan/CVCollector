package cvc.logic.repositories;

import cvc.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<Users,Long>, JpaSpecificationExecutor<Users> {
    Optional<Users> byUsername(String username);
}
