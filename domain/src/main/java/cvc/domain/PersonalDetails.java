package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.GregorianCalendar;

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

    private String MaritalStatus;

    private String CareerTitle;

    private String AdditionalDetails;


    public PersonalDetails() {}

    public PersonalDetails(String firstName, String lastName, Gender gender, LocalDate dateOfBirth, String father, String mother, String nationality, String maritalStatus, String careerTitle, String additionalDetails) {
        FirstName = firstName;
        LastName = lastName;
        Gender = gender.getId();
        DateOfBirth = dateOfBirth;
        Father = father;
        Mother = mother;
        Nationality = nationality;
        MaritalStatus = maritalStatus;
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

    public String getMaritalStatus() {
        return MaritalStatus;
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

    public void setGender(short gender) {
        Gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public void setDob(client.entities.Date dateOfBirth) {
        DateOfBirth = LocalDate.parse(dateOfBirth.toString());
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

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
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
