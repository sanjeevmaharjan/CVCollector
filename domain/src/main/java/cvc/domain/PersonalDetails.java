package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import enums.Genders;
import enums.MaritalStatuses;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PersonalDetails extends PersistentObject  {

    @OneToOne(optional = false, mappedBy = "Personal", fetch = FetchType.LAZY, targetEntity = Cv.class)
    @JsonIgnore
    private Cv Cv;

    private String FirstName;

    private String LastName;

    @Column(nullable = true)
    private short Gender;

    @Column(name = "dob")
    private LocalDate DateOfBirth;

    private String Father;

    private String Mother;

    private String Nationality;

    private short MaritalStatus;

    private String CareerTitle;

    private String AdditionalDetails;


    public PersonalDetails() {}

    public PersonalDetails(String firstName, String lastName, Genders gender, LocalDate dateOfBirth, String father, String mother, String nationality, MaritalStatuses maritalStatus, String careerTitle, String additionalDetails) {
        FirstName = firstName;
        LastName = lastName;
        Gender = gender.getId();
        DateOfBirth = dateOfBirth;
        Father = father;
        Mother = mother;
        Nationality = nationality;
        MaritalStatus = maritalStatus.getId();
        CareerTitle = careerTitle;
        AdditionalDetails = additionalDetails;
    }

    public PersonalDetails(String firstName, String lastName, Genders gender, String dateOfBirth, String father,
            String mother, String nationality, MaritalStatuses maritalStatus, String careerTitle,
            String additionalDetails) {
        FirstName = firstName;
        LastName = lastName;
        Gender = gender.getId();
        DateOfBirth = LocalDate.parse(dateOfBirth);
        Father = father;
        Mother = mother;
        Nationality = nationality;
        MaritalStatus = maritalStatus.getId();
        CareerTitle = careerTitle;
        AdditionalDetails = additionalDetails;
    }

    //region getters and setters

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public short getGender() {
        return Gender;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public String getFather() {
        return Father;
    }

    public String getMother() {
        return Mother;
    }

    public String getNationality() {
        return Nationality;
    }

    public MaritalStatuses getMaritalStatus() {
        return MaritalStatuses.getById(MaritalStatus);
    }

    public String getCareerTitle() {
        return CareerTitle;
    }

    public String getAdditionalDetails() {
        return AdditionalDetails;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setGender(Genders gender) {
        Gender = gender.getId();
    }

    public void setGender(String gender) {
        if (gender == null || gender == "") {
            return;
        }
        Gender = Short.parseShort(gender);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        try {
            DateOfBirth = LocalDate.parse(dateOfBirth);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void setFather(String father) {
        Father = father;
    }

    public void setMother(String mother) {
        Mother = mother;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public void setMaritalStatus(MaritalStatuses maritalStatus) {
        MaritalStatus = maritalStatus.getId();
    }

    public void setMaritalStatus(String maritalStatus) {
        if (maritalStatus == null || maritalStatus == ""){
            return;
        }
        MaritalStatus = Short.parseShort(maritalStatus);
    }

    public void setCareerTitle(String careerTitle) {
        CareerTitle = careerTitle;
    }

    public void setAdditionalDetails(String additionalDetails) {
        AdditionalDetails = additionalDetails;
    }

    @JsonIgnore
    public cvc.domain.Cv getCv() {
        return Cv;
    }

    public void setCv(cvc.domain.Cv cv) {
        Cv = cv;
    }

    //endregion getters and setters
}
