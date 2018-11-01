package cvc.logic.specifications;

import cvc.domain.Users;
import cvc.domain.Users_;
import org.springframework.data.jpa.domain.Specification;

public final class UserSpecifications {
    public static Specification<Users> thisUsername(String username) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(
		        criteriaBuilder.lower(root.get(Users_.Username)),
		        username.toLowerCase()
		);
    }
}
