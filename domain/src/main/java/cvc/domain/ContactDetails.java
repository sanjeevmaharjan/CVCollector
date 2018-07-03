package cvc.domain;

import javax.persistence.Entity;

@Entity
public class ContactDetails extends PersistentObject {

    private String Phone;

    private String Email;

    private String Country;

    private String State;

    private String City;

    private String Street;

    private String ProfileLinks;

    public ContactDetails() {}

    public ContactDetails(String phone, String email, String country, String state, String city, String street) {
        Phone = phone;
        Email = email;
        Country = country;
        State = state;
        City = city;
        Street = street;
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

    public String getStreet() {
        return Street;
    }

    public String getProfileLinks() {
        return ProfileLinks;
    }

    //endregion getters and setters
}
