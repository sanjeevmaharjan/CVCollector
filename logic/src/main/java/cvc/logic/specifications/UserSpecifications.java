package cvc.logic.specifications;

import cvc.domain.Cv;
import cvc.domain.Cv_;
import cvc.domain.Users;
import cvc.domain.Users_;
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
            Join<Cv, Users> join = root.join(Cv_.User);

            return criteriaBuilder.equal(join.get(Users_.Username), username);
        };
    }
}
