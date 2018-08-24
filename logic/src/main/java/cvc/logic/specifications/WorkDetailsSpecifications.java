package cvc.logic.specifications;

import cvc.domain.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;

public final class WorkDetailsSpecifications {

    public static Specification<Cv> MinJobExp(int jobExpMin) {
        return new Specification<Cv>() {
            @Override
            public Predicate toPredicate(Root<Cv> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Cv, ProfessionalDetails> professionalDetailsJoin = root.join(Cv_.Professional);
                Join<ProfessionalDetails, WorkPlace> workPlaceJoin = professionalDetailsJoin.join(ProfessionalDetails_.WorkPlaces);



                criteriaBuilder.(
                        workPlaceJoin.<LocalDate>get(WorkPlace_.StartDate),
                        workPlaceJoin.<LocalDate>get(WorkPlace_.EndDate)
                );
            }
        }
    }
}
