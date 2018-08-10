package cvc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class EducationDetails extends PersistentObject {

    @OneToOne(mappedBy = "Education")
    private Cv Cv;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Institution> Institutions;

    // @TODO Education Percentage

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

    public void setInstitutions(List<Institution> institutions) {
        Institutions = institutions;
    }

    public void setAdditionalDetails(String additionalDetails) {
        AdditionalDetails = additionalDetails;
    }

    //endregion getters and setters
}
