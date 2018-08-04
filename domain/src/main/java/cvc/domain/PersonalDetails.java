package cvc.domain;

import enums.Gender;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PersonalDetails extends PersistentObject  {

    private String FirstName;

    private String LastName;

    private short Gender;

    @Column(name = "dob")
    private Date DateOfBirth;

    private String Father;

    private String Mother;

    private String Nationality;

    private String MaritalStatus;

    private String CareerTitle;

    private String AdditionalDetails;


    public PersonalDetails() {}

    public PersonalDetails(String firstName, String lastName, Gender gender, Date dateOfBirth, String father, String mother, String nationality, String maritalStatus, String careerTitle, String additionalDetails) {
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

    public Date getDateOfBirth() {
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


    //endregion getters and setters
}
