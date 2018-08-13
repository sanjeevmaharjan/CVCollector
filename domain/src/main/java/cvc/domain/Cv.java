package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Cv extends PersistentObject {

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_id", unique = true, nullable = false)
    @NotNull
    private PersonalDetails Personal;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", unique = true, nullable = false)
    @NotNull
    private ContactDetails Contact;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "education_id", unique = true, nullable = false)
    @NotNull
    private EducationDetails Education;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "professional_id", unique = true, nullable = false)
    @NotNull
    private ProfessionalDetails Professional;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", unique = true, nullable = false)
    @NotNull
    private ProjectDetails Project;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "additional_info_id", unique = true, nullable = false)
    @NotNull
    private AdditionalInfo AdditionalInfo;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "Cv", orphanRemoval = true)
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


    // Override to include id because of @JsonIgnore in superclass
    @Override
    @JsonIgnore(false)
    public long getId() {
        return super.getId();
    }

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

    public void setPersonal(PersonalDetails personal) {
        Personal = personal;
    }

    public void setContact(ContactDetails contact) {
        Contact = contact;
    }

    public void setEducation(EducationDetails education) {
        Education = education;
    }

    public void setProfessional(ProfessionalDetails professional) {
        Professional = professional;
    }

    public void setProject(ProjectDetails project) {
        Project = project;
    }

    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        AdditionalInfo = additionalInfo;
    }

    public void setAwards(List<Award> awards) {
        Awards = awards;
    }

    //endregion getters and setters
}
