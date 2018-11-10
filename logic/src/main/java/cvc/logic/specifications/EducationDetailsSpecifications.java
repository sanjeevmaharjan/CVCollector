package cvc.logic.specifications;

import cvc.domain.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public final class EducationDetailsSpecifications {

    public static Specification<Cv> MinScore(float minScore) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, EducationDetails> education = root.join(Cv_.Education);
            Join<EducationDetails, Institution> institutionJoin = education.join(EducationDetails_.Institutions);

            return criteriaBuilder.ge(institutionJoin.get(Institution_.Score), minScore);
        };
    }

    public static Specification<Cv> MaxScore(float maxScore) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, EducationDetails> education = root.join(Cv_.Education);
            Join<EducationDetails, Institution> institutionJoin = education.join(EducationDetails_.Institutions);

            return criteriaBuilder.le(institutionJoin.get(Institution_.Score), maxScore);
        };
    }
}
