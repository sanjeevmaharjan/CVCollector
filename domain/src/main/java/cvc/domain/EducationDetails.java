package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class EducationDetails extends PersistentObject {

    @OneToOne(optional = false, mappedBy = "Education", fetch = FetchType.LAZY, targetEntity = Cv.class)
    @JsonIgnore
    private Cv Cv;

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

    public void setInstitutions(List<Institution> institutions) {
        Institutions = institutions;
    }

    public void setAdditionalDetails(String additionalDetails) {
        AdditionalDetails = additionalDetails;
    }

    @JsonIgnore
    public Cv getCv() {
        return Cv;
    }

    @JsonIgnore
    public void setCv(Cv cv) {
        Cv = cv;
    }

    //endregion getters and setters
}
