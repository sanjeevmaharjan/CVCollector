package cvc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class EducationDetails extends PersistentObject {
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Institution> Institutions;

    private String Summary;

    public EducationDetails() {}

    public EducationDetails(List<Institution> institutions, String summary) {
        Institutions = institutions;
        Summary = summary;
    }

    //region getters and setters

    public List<Institution> getInstitutions() {
        return Institutions;
    }

    public String getSummary() {
        return Summary;
    }

    //endregion getters and setters
}
