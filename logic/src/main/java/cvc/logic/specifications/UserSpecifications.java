package cvc.logic.specifications;

import cvc.domain.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

public final class UserSpecifications {
    public static Specification<Users> thisUsername(String username) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(
		        criteriaBuilder.lower(root.get(Users_.Username)),
		        username.toLowerCase()
		);
    }

    public static Specification<Cv> cvOfThisUser(String username) {
        return (root, query, criteriaBuilder) -> {
            Join<Cv, Links> joinLinks = root.join(Cv_.Links);
            Join<Links, Users> join = joinLinks.join(Links_.User);

            return criteriaBuilder.equal(join.get(Users_.Username), username);
        };
    }
}
