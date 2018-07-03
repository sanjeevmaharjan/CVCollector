package cvc.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProfessionalDetails extends PersistentObject  {
    private String ProfessionalSkills;

    @OneToMany
    private List<WorkPlace> WorkPlaces;

    private String Summary;

    public ProfessionalDetails() {}

    public ProfessionalDetails(String professionalSkills, List<WorkPlace> workPlaces, String summary) {
        ProfessionalSkills = professionalSkills;
        WorkPlaces = workPlaces;
        Summary = summary;
    }

    //region getters and setters

    public String getProfessionalSkills() {
        return ProfessionalSkills;
    }

    public List<WorkPlace> getWorkPlaces() {
        return WorkPlaces;
    }

    public String getSummary() {
        return Summary;
    }

    //endregion getters and setters
}
