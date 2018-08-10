package cvc.logic.specifications;

import cvc.domain.PersonalDetails;
import cvc.domain.PersonalDetails_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public final class PersonalDetailsSpecifications {

    public static Specification<PersonalDetails>  nameStartsWith(String nameStart) {
        return new Specification<PersonalDetails>() {
            @Override
            public Predicate toPredicate(Root<PersonalDetails> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                String startsWithPattern = getStartsWithPattern(nameStart);
                criteriaQuery.select(root.get(PersonalDetails_.Cv));
                return criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get(PersonalDetails_.FirstName)), startsWithPattern),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get(PersonalDetails_.LastName)), startsWithPattern)
                );
            }
        };
    }

    public static Specification<PersonalDetails> ageLessThan(int ageMax) {
        return new Specification<PersonalDetails>() {
            @Override
            public Predicate toPredicate(Root<PersonalDetails> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                LocalDate date = LocalDate.now().minusYears(ageMax);
                return criteriaBuilder.greaterThanOrEqualTo(
                        root.get(PersonalDetails_.DateOfBirth), date
                );
            }
        };
    }

    public static Specification<PersonalDetails> ageGreaterThan(int ageMin) {
        return new Specification<PersonalDetails>() {
            @Override
            public Predicate toPredicate(Root<PersonalDetails> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                LocalDate date = LocalDate.now().minusYears(ageMin);
                return criteriaBuilder.lessThanOrEqualTo(
                        root.get(PersonalDetails_.DateOfBirth), date
                );
            }
        };
    }

    private static String getStartsWithPattern(String startsWith) {
        if (startsWith == null || startsWith.isEmpty()) {
            return "%";
        }

        return startsWith.toLowerCase() + "%";
    }
}
