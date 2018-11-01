package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProfessionalDetails extends PersistentObject  {

    @OneToOne(optional = false, mappedBy = "Professional", fetch = FetchType.LAZY, targetEntity = Cv.class)
    @JsonIgnore
    private Cv Cv;

    private String ProfessionalSkills;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<WorkPlace> WorkPlaces;

    private String AdditionalDetails;

    public ProfessionalDetails() {}

    public ProfessionalDetails(String professionalSkills, List<WorkPlace> workPlaces, String additionalDetails) {
        ProfessionalSkills = professionalSkills;
        WorkPlaces = workPlaces;
        AdditionalDetails = additionalDetails;
    }

    //region getters and setters

    public String getProfessionalSkills() {
        return ProfessionalSkills;
    }

    public List<WorkPlace> getWorkPlaces() {
        return WorkPlaces;
    }

    public String getAdditionalDetails() {
        return AdditionalDetails;
    }

    public void setProfessionalSkills(String professionalSkills) {
        ProfessionalSkills = professionalSkills;
    }

    public void setWorkPlaces(List<WorkPlace> workPlaces) {
        WorkPlaces = workPlaces;
    }

    public void setAdditionalDetails(String additionalDetails) {
        AdditionalDetails = additionalDetails;
    }

    @JsonIgnore
    public Cv getCv() {
        return Cv;
    }

    public void setCv(Cv cv) {
        Cv = cv;
    }

    //endregion getters and setters
}
