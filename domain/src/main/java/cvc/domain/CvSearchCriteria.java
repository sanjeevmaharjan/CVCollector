package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import enums.Genders;
import enums.MaritalStatuses;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "CvSearchCriteria.findByUser", query = "select criteria from CvSearchCriteria criteria join criteria.User u where u.id = ?1")
public class CvSearchCriteria extends PersistentObject {

    @ManyToOne(fetch = FetchType.LAZY)
    private Users User;

    // region Personal Details Criteria
    private String Name = null;

    private Genders Gender = Genders.Unspecified;

    // For Age
    private Short MinAge = 0;

    private Short MaxAge = 200;

    private String Nationality;

    private MaritalStatuses MaritalStatus;

    private String CareerTitle;

    // endregion Personal Details Criteria

    // region Contact Details Criteria

    private String Country;

    private String City;

    private Boolean RelocationCriteria = false;

    // endregion Contact Details Criteria

    // region Education Details Criteria

    private Float AcademicScoreMin;

    private Float AcademicScoreMax;

    // endregion Education Details Criteria

    // region Work Details Criteria

    private Integer JobExperienceMin;

    private Integer JobExperienceMax;

    // endregion Work Details Criteria

    // region Project Details Criteria

    private Integer project;

    // endregion Project Details Criteria

    // region Additional Fields Criteria

    private String PersonalAdditional;

    private String ContactAdditional;

    private String EducationAdditional;

    private String ProfessionalAdditional;

    private String ProjectAdditional;

    private String AdditionalNotes;

    // endregion Additional Fields Criteria

    // region getters and setters

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return Name;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setName(String name) {
        Name = name;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Genders getGender() {
        return Gender;
    }

    public void setGender(Genders gender) {
        Gender = gender;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public short getMinAge() {
        return MinAge;
    }

    public void setMinAge(short minAge) {
        MinAge = minAge;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public short getMaxAge() {
        return MaxAge;
    }

    public void setMaxAge(short maxAge) {
        MaxAge = maxAge;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public MaritalStatuses getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(MaritalStatuses maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCareerTitle() {
        return CareerTitle;
    }

    public void setCareerTitle(List<String> careerTitle) {
        CareerTitle = String.join(",", careerTitle);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public float getAcademicScoreMin() {
        return AcademicScoreMin;
    }

    public void setAcademicScoreMin(float academicScoreMin) {
        AcademicScoreMin = academicScoreMin;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public float getAcademicScoreMax() {
        return AcademicScoreMax;
    }

    public void setAcademicScoreMax(float academicScoreMax) {
        AcademicScoreMax = academicScoreMax;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int getJobExperienceMin() {
        return JobExperienceMin;
    }

    public void setJobExperienceMin(int jobExperienceMin) {
        JobExperienceMin = jobExperienceMin;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int getJobExperienceMax() {
        return JobExperienceMax;
    }

    public void setJobExperienceMax(int jobExperienceMax) {
        JobExperienceMax = jobExperienceMax;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPersonalAdditional() {
        return PersonalAdditional;
    }

    public void setPersonalAdditional(String personalAdditional) {
        PersonalAdditional = personalAdditional;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getContactAdditional() {
        return ContactAdditional;
    }

    public void setContactAdditional(String contactAdditional) {
        ContactAdditional = contactAdditional;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEducationAdditional() {
        return EducationAdditional;
    }

    public void setEducationAdditional(String educationAdditional) {
        EducationAdditional = educationAdditional;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getProfessionalAdditional() {
        return ProfessionalAdditional;
    }

    public void setProfessionalAdditional(String professionalAdditional) {
        ProfessionalAdditional = professionalAdditional;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getProjectAdditional() {
        return ProjectAdditional;
    }

    public void setProjectAdditional(String projectAdditional) {
        ProjectAdditional = projectAdditional;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAdditionalNotes() {
        return AdditionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        AdditionalNotes = additionalNotes;
    }

    public boolean isRelocationCriteria() {
        return RelocationCriteria;
    }

    public void setRelocationCriteria(boolean relocationCriteria) {
        RelocationCriteria = relocationCriteria;
    }

    @JsonIgnore
    public Users getUser() {
        return User;
    }

    public void setUser(Users user) {
        User = user;
    }

    // endregion getters and setters
}
