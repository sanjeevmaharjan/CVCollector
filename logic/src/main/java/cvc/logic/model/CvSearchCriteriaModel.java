package cvc.logic.model;

import cvc.domain.Cv;
import cvc.domain.CvSearchCriteria;
import cvc.logic.specifications.ContactDetailsSpecifications;
import cvc.logic.specifications.PersonalDetailsSpecifications;
import enums.Genders;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

// Default values Considered in search logic. Not might be used though
public class CvSearchCriteriaModel {
    private CvSearchCriteria cvSearchCriteria = null;

    private Specification<Cv> specs = null;

    public CvSearchCriteriaModel() { }

    public CvSearchCriteriaModel(CvSearchCriteria cvSearchCriteria) {
        this.cvSearchCriteria = cvSearchCriteria;
    }

    // region Other functions

    public CvSearchCriteriaModel forCriteria(CvSearchCriteria criteria) {
        this.cvSearchCriteria = criteria;
        return this;
    }
    public Specification<Cv> getSpecs() {
        if (cvSearchCriteria == null) {
            return null;
        }

        // region Personal Details Specs
        if (isNotNullOrEmpty(cvSearchCriteria.getName())) {
            AddSpec(PersonalDetailsSpecifications.nameStartsWith(cvSearchCriteria.getName()));
        }

        if (!cvSearchCriteria.getGender().equals(Genders.Unspecified)) {
            AddSpec(PersonalDetailsSpecifications.thisGenderOnly(cvSearchCriteria.getGender()));
        }

        if (cvSearchCriteria.getMinAge() > 0) {
            AddSpec(PersonalDetailsSpecifications.ageGreaterThan(cvSearchCriteria.getMinAge()));
        }

        if (cvSearchCriteria.getMaxAge() < 200 ) {
            AddSpec(PersonalDetailsSpecifications.ageLessThan(cvSearchCriteria.getMaxAge()));
        }

        if (isNotNullOrEmpty(cvSearchCriteria.getNationality())) {
            AddSpec(PersonalDetailsSpecifications.thisNationality(cvSearchCriteria.getNationality()));
        }

        if (isNotNullOrEmpty(cvSearchCriteria.getMaritalStatus())) {
            AddSpec(PersonalDetailsSpecifications.theseMaritalStatuses(cvSearchCriteria.getMaritalStatus()));
        }

        if (isNotNullOrEmpty(cvSearchCriteria.getCareerTitle())) {
            AddSpec(PersonalDetailsSpecifications.theseCareerTitles(cvSearchCriteria.getCareerTitle()));
        }
        // endregion Personal Details Specs

        if (cvSearchCriteria.isRelocationCriteria()) {
            AddSpec(ContactDetailsSpecifications.canRelocateOnly());
        }

        return specs;
    }

    public Specification<Cv> getSpecs(CvSearchCriteria criteria) {
        this.cvSearchCriteria = criteria;

        return getSpecs();
    }

    private void AddSpec(Specification<Cv> spec) {
        if (spec == null) return;

        if (specs == null) {
            specs = spec;
            return;
        }

        specs = specs.and(spec);
    }

    private boolean isNotNullOrEmpty (String value) {
        return value != null && !value.isEmpty();
    }

    private boolean isNotNullOrEmpty (List value) {
        return value != null && !value.isEmpty();
    }

    // endregion Other functions
}
