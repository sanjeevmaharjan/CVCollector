package cvc.domain;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class ContactDetails extends PersistentObject {

    private String Phone;

    private String Email;

    private String Country;

    private String State;

    private String City;

    private int Zip;

    private String ProfileLinks;

    private String AdditionalDetails;

    public ContactDetails() {}

    public ContactDetails(List<String> phone, List<String> email, String country, String state, String city, int zip, String profileLinks, String additionalDetails) {
        Phone = String.join("|", phone);
        Email = String.join("|", email);
        Country = country;
        State = state;
        City = city;
        Zip = zip;
        ProfileLinks = profileLinks;
        AdditionalDetails = additionalDetails;
    }

    //region getters and setters

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getCountry() {
        return Country;
    }

    public String getState() {
        return State;
    }

    public String getCity() {
        return City;
    }

    public int getZip() {
        return Zip;
    }

    public String getProfileLinks() {
        return ProfileLinks;
    }

    public String getAdditionalDetails() {
        return AdditionalDetails;
    }

    //endregion getters and setters
}
