package cvc.logic.specifications;

import cvc.domain.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public final class WorkDetailsSpecifications {

    public static Specification<Cv> minJobExp(int jobExpMin) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, ProfessionalDetails> professionalDetailsJoin = root.join(Cv_.Professional);
            Join<ProfessionalDetails, WorkPlace> workPlaceJoin = professionalDetailsJoin
                    .join(ProfessionalDetails_.WorkPlaces);

            return criteriaBuilder.ge(workPlaceJoin.get(WorkPlace_.TimeEngaged), jobExpMin);
        };
    }

    public static Specification<Cv> maxJobExp(int jobExpMax) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, ProfessionalDetails> professionalDetailsJoin = root.join(Cv_.Professional);
            Join<ProfessionalDetails, WorkPlace> workPlaceJoin = professionalDetailsJoin
                    .join(ProfessionalDetails_.WorkPlaces);

            return criteriaBuilder.le(workPlaceJoin.get(WorkPlace_.TimeEngaged), jobExpMax);
        };
    }
}
