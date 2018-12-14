package cvc.logic.specifications;

import cvc.domain.Cv;
import cvc.domain.Cv_;
import cvc.domain.PersonalDetails;
import cvc.domain.PersonalDetails_;
import cvc.logic.specifications.common.PatternHelper;
import enums.Genders;
import enums.MaritalStatuses;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class PersonalDetailsSpecifications {

    public static Specification<Cv> nameStartsWith(String nameStart) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
            String startsWithPattern = PatternHelper.getStartsWithPattern(nameStart);
            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(personal.get(PersonalDetails_.FirstName)),
                            startsWithPattern),
                    criteriaBuilder.like(criteriaBuilder.lower(personal.get(PersonalDetails_.LastName)),
                            startsWithPattern));
        };
    }

    public static Specification<Cv> thisGenderOnly(Genders gender) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
            return criteriaBuilder.equal(personal.get(PersonalDetails_.Gender), gender);
        };
    }

    public static Specification<Cv> ageLessThan(int ageMax) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
            LocalDate date = LocalDate.now().minusYears(ageMax);
            return criteriaBuilder.greaterThanOrEqualTo(personal.get(PersonalDetails_.DateOfBirth), date);
        };
    }

    public static Specification<Cv> ageGreaterThan(int ageMin) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
            LocalDate date = LocalDate.now().minusYears(ageMin);
            return criteriaBuilder.lessThanOrEqualTo(personal.get(PersonalDetails_.DateOfBirth), date);
        };
    }

    public static Specification<Cv> thisNationality(String nationContains) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
            String containsPattern = PatternHelper.getContainsPattern(nationContains);
            return criteriaBuilder.like(criteriaBuilder.lower(personal.get(PersonalDetails_.Nationality)),
            containsPattern);
        };
    }

    public static Specification<Cv> theseMaritalStatuses(MaritalStatuses maritalStatus) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
            return criteriaBuilder.equal(personal.get(PersonalDetails_.MaritalStatus), maritalStatus);
        };
    }

    public static Specification<Cv> theseCareerTitles(String careerstring) {
        String[] careers = careerstring.split("\\s*,\\s*");
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, PersonalDetails> personal = root.join(Cv_.Personal);
            return personal.get(PersonalDetails_.CareerTitle).in(careers);
        };
    }
}
