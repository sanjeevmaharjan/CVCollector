package cvc.domain;

import enums.Genders;
import enums.MaritalStatuses;
import java.util.List;

public class CvSearchCriteria {
    // region Personal Details Criteria
    private String Name = null;

    private Genders Gender = Genders.Unspecified;

    // For Age
    private short MinAge = 0;
    private short MaxAge = 200;

    private String Nationality;

    private List<MaritalStatuses> MaritalStatus;

    private List<String> CareerTitle;

    // endregion Personal Details Criteria

    // region Contact Details Criteria

    private String Country;

    private String City;

    private boolean RelocationCriteria;

    // endregion Contact Details Criteria

    // region Education Details Criteria

    private float AcademicScoreMin;

    private float AcademicScoreMax;

    // endregion Education Details Criteria

    // region Work Details Criteria

    private int JobExperienceMin;

    private int JobExperienceMax;

    // endregion Work Details Criteria

    // region Project Details Criteria

    private int project;

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Genders getGender() {
        return Gender;
    }

    public void setGender(Genders gender) {
        Gender = gender;
    }

    public short getMinAge() {
        return MinAge;
    }

    public void setMinAge(short minAge) {
        MinAge = minAge;
    }

    public short getMaxAge() {
        return MaxAge;
    }

    public void setMaxAge(short maxAge) {
        MaxAge = maxAge;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public List<MaritalStatuses> getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(List<MaritalStatuses> maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public List<String> getCareerTitle() {
        return CareerTitle;
    }

    public void setCareerTitle(List<String> careerTitle) {
        CareerTitle = careerTitle;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public float getAcademicScoreMin() {
        return AcademicScoreMin;
    }

    public void setAcademicScoreMin(float academicScoreMin) {
        AcademicScoreMin = academicScoreMin;
    }

    public float getAcademicScoreMax() {
        return AcademicScoreMax;
    }

    public void setAcademicScoreMax(float academicScoreMax) {
        AcademicScoreMax = academicScoreMax;
    }

    public int getJobExperienceMin() {
        return JobExperienceMin;
    }

    public void setJobExperienceMin(int jobExperienceMin) {
        JobExperienceMin = jobExperienceMin;
    }

    public int getJobExperienceMax() {
        return JobExperienceMax;
    }

    public void setJobExperienceMax(int jobExperienceMax) {
        JobExperienceMax = jobExperienceMax;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public String getPersonalAdditional() {
        return PersonalAdditional;
    }

    public void setPersonalAdditional(String personalAdditional) {
        PersonalAdditional = personalAdditional;
    }

    public String getContactAdditional() {
        return ContactAdditional;
    }

    public void setContactAdditional(String contactAdditional) {
        ContactAdditional = contactAdditional;
    }

    public String getEducationAdditional() {
        return EducationAdditional;
    }

    public void setEducationAdditional(String educationAdditional) {
        EducationAdditional = educationAdditional;
    }

    public String getProfessionalAdditional() {
        return ProfessionalAdditional;
    }

    public void setProfessionalAdditional(String professionalAdditional) {
        ProfessionalAdditional = professionalAdditional;
    }

    public String getProjectAdditional() {
        return ProjectAdditional;
    }

    public void setProjectAdditional(String projectAdditional) {
        ProjectAdditional = projectAdditional;
    }

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

    // endregion getters and setters
}
