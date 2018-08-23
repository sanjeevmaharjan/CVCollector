package cvc.logic.specifications;

import cvc.domain.Cv;
import cvc.domain.Cv_;
import cvc.domain.PersonalDetails;
import cvc.domain.PersonalDetails_;
import enums.EGender;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;

public final class PersonalDetailsSpecifications {

    public static Specification<Cv> nameStartsWith(String nameStart) {
        return new Specification<Cv>() {
            @Override
            public Predicate toPredicate(Root<Cv> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
                String startsWithPattern = getStartsWithPattern(nameStart);
                return criteriaBuilder.or(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(personal.get(PersonalDetails_.FirstName)), startsWithPattern
                        ),
                        criteriaBuilder.like(
                                criteriaBuilder.lower(personal.get(PersonalDetails_.LastName)), startsWithPattern
                        )
                );
            }
        };
    }

    public static Specification<Cv> thisGenderOnly(EGender gender) {
        return new Specification<Cv>() {
            @Override
            public Predicate toPredicate(Root<Cv> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
                return criteriaBuilder.equal(personal.get(PersonalDetails_.Gender), gender);
            }
        };
    }

    public static Specification<Cv> ageLessThan(int ageMax) {
        return new Specification<Cv>() {
            @Override
            public Predicate toPredicate(Root<Cv> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
                LocalDate date = LocalDate.now().minusYears(ageMax);
                return criteriaBuilder.greaterThanOrEqualTo(
                        personal.get(PersonalDetails_.DateOfBirth), date
                );
            }
        };
    }

    public static Specification<Cv> ageGreaterThan(int ageMin) {
        return new Specification<Cv>() {
            @Override
            public Predicate toPredicate(Root<Cv> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
                LocalDate date = LocalDate.now().minusYears(ageMin);
                return criteriaBuilder.lessThanOrEqualTo(
                        personal.get(PersonalDetails_.DateOfBirth), date
                );
            }
        };
    }

    public static Specification<Cv> thisNationality(String nationContains) {
        return new Specification<Cv>() {
            @Override
            public Predicate toPredicate(Root<Cv> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
                String containsPattern = getContainsPattern(nationContains);
                return criteriaBuilder.like(
                        criteriaBuilder.lower(personal.get(PersonalDetails_.Nationality)), nationContains
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

    private static String getContainsPattern(String startsWith) {
        if (startsWith == null || startsWith.isEmpty()) {
            return "%";
        }

        return "%" + startsWith.toLowerCase() + "%";
    }
}
