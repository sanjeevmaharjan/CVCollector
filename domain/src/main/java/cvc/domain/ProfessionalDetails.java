package cvc.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProfessionalDetails extends PersistentObject  {
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

    //endregion getters and setters
}
