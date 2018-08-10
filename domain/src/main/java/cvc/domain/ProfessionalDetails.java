package cvc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class ProfessionalDetails extends PersistentObject  {

    @OneToOne(mappedBy = "Professional")
    private Cv Cv;

    private String ProfessionalSkills;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<WorkPlace> WorkPlaces;

    // @TODO add workplace experience

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

    //endregion getters and setters
}
