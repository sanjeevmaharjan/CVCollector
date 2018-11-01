package cvc.logic.specifications;

import cvc.domain.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public final class ContactDetailsSpecifications {

    public static Specification<Cv> canRelocateOnly() {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, ContactDetails> contact = root.join(Cv_.Contact);
            return criteriaBuilder.isTrue(contact.get(ContactDetails_.CanRelocate));
        };
    }

    // TODO Distance Calculation
}
