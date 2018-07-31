package cvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PersonalDetails extends PersistentObject  {

    private String FirstName;

    private String LastName;

    private String Gender;

    @Column(name = "dob")
    private Date DateOfBirth;

    private String Father;

    private String Mother;

    private String Nationality;

    private String MaritalStatus;

    private String CareerTitle;

    private String summary;


    public PersonalDetails() {}

    public PersonalDetails(String FirstName, String LastName, Date dateOfBirth, String father, String mother, String nationality, String maritalStatus, String careerTitle, String summary) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DateOfBirth = dateOfBirth;
        this.Father = father;
        this.Mother = mother;
        this.Nationality = nationality;
        this.MaritalStatus = maritalStatus;
        this.CareerTitle = careerTitle;
        this.summary = summary;
    }

    //region getters and setters


    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
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

    public String getSummary() {
        return summary;
    }

    //endregion getters and setters
}
