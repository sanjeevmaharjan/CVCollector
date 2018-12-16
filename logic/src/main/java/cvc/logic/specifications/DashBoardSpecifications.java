package cvc.logic.specifications;

import cvc.domain.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;

public final class DashBoardSpecifications {

    public static Specification<Cv> NumCvs(Long id) {
        return ((root, query, criteriaBuilder) -> {
            Join<Cv, Links> join = root.join(Cv_.Links);
            Join<Links, Users> user = join.join(Links_.User);
            return criteriaBuilder.equal(user.get(Users_.Id), id);
        });
    }

    public static Specification<Cv> NumCvsToday(Long id) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, Links> join = root.join(Cv_.Links);
            Join<Links, Users> user = join.join(Links_.User);
            final LocalDate now = LocalDate.now();
            final LocalDate oneDayBefore = now.minusDays(1);
            return criteriaBuilder.and(
                    criteriaBuilder.between(root.get(Cv_.SubmittedTime), oneDayBefore, now),
                    criteriaBuilder.equal(user.get(Users_.Id), id)
            );
        };
    }

    public static Specification<Cv> NumCvsThisWeek(Long id) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<Cv, Links> join = root.join(Cv_.Links);
            Join<Links, Users> user = join.join(Links_.User);
            final LocalDate now = LocalDate.now();
            final LocalDate weekBefore = now.minusDays(7);
            return criteriaBuilder.and(
                    criteriaBuilder.between(root.get(Cv_.SubmittedTime), weekBefore, now),
                    criteriaBuilder.equal(user.get(Users_.Id), id)
            );
        };
    }
}
