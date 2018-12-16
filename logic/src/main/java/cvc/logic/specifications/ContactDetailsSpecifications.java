package cvc.logic.specifications;

import cvc.domain.*;
import cvc.logic.specifications.common.PatternHelper;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public final class ContactDetailsSpecifications {

    public static Specification<Cv> canRelocateOnly() {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, ContactDetails> contact = root.join(Cv_.Contact);
            return criteriaBuilder.isTrue(contact.get(ContactDetails_.CanRelocate));
        };
    }

    public static Specification<Cv> thisCity(String city) {
        return (root, query, criteriaBuilder) -> {
            Join<Cv, ContactDetails> contact = root.join(Cv_.Contact);
            return criteriaBuilder.like(contact.get(ContactDetails_.City), PatternHelper.getContainsPattern(city));
        };
    }

    public static Specification<Cv> thisCountry(String country) {
        return (root, query, criteriaBuilder) -> {
            Join<Cv, ContactDetails> contact = root.join(Cv_.Contact);
            return criteriaBuilder.like(contact.get(ContactDetails_.Country), PatternHelper.getContainsPattern(country));
        };
    }

    // TODO Distance Calculation
}
