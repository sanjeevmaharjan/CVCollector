package cvc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Cv extends PersistentObject {
    @OneToOne(cascade = {CascadeType.ALL})
    private PersonalDetails Personal;

    @OneToOne(cascade = {CascadeType.ALL})
    private ContactDetails Contact;

    @OneToOne(cascade = {CascadeType.ALL})
    private EducationDetails Education;

    @OneToOne(cascade = {CascadeType.ALL})
    private ProfessionalDetails Professional;

    @OneToOne(cascade = {CascadeType.ALL})
    private ProjectDetails Project;

    public Cv() {}

    public Cv(PersonalDetails personal, ContactDetails contact, EducationDetails education, ProfessionalDetails professional, ProjectDetails project) {
        Personal = personal;
        Contact = contact;
        Education = education;
        Professional = professional;
        Project = project;
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

    //endregion getters and setters
}
