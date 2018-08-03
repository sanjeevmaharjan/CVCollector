package cvc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class EducationDetails extends PersistentObject {
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Institution> Institutions;

    private String AdditionalDetails;

    public EducationDetails() {}

    public EducationDetails(List<Institution> institutions, String additionalDetails) {
        Institutions = institutions;
        AdditionalDetails = additionalDetails;
    }

    //region getters and setters

    public List<Institution> getInstitutions() {
        return Institutions;
    }

    public String getAdditionalDetails() {
        return AdditionalDetails;
    }


    //endregion getters and setters
}
