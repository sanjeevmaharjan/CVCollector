package cvc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Cv extends PersistentObject {
    private PersonalDetails Personal;

    private ContactDetails Contact;

    private EducationDetails Education;

    private ProfessionalDetails Professional;

    private ProjectDetails Project;

    private AdditionalInfo AdditionalInfo;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Award> Awards;

    public Cv() {}

    public Cv(PersonalDetails personal, ContactDetails contact, EducationDetails education, ProfessionalDetails professional, ProjectDetails project, AdditionalInfo additionalInfo, List<Award> awards) {
        Personal = personal;
        Contact = contact;
        Education = education;
        Professional = professional;
        Project = project;
        AdditionalInfo = additionalInfo;
        Awards = awards;
    }

    //region getters and setters

    public PersonalDetails getPersonal() {
        return Personal;
    }

    public ContactDetails getContact() {
        return Contact;
    }

    public EducationDetails getEducation() {
        return Education;
    }

    public ProfessionalDetails getProfessional() {
        return Professional;
    }

    public ProjectDetails getProject() {
        return Project;
    }

    public cvc.domain.AdditionalInfo getAdditionalInfo() {
        return AdditionalInfo;
    }

    public List<Award> getAwards() {
        return Awards;
    }


    //endregion getters and setters
}
