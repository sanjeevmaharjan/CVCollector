package cvc.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Cv extends PersistentObject {
    @OneToOne
    private PersonalDetails Personal;

    @OneToOne
    private ContactDetails Contact;

    @OneToOne
    private EducationDetails Education;

    @OneToOne
    private ProfessionalDetails Professional;

    @OneToOne
    private ProjectDetails Project;

    public Cv() {}

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

    //endregion getters and setters
}
