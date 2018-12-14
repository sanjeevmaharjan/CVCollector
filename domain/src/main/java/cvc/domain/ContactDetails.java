package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ContactDetails extends PersistentObject {

    @OneToOne(optional = false, mappedBy = "Contact", fetch = FetchType.LAZY, targetEntity = Cv.class)
    @JsonIgnore
    private Cv Cv;

    private String PhoneList;

    private String EmailList;

    private String Country;

    private String State;

    private String City;

    private boolean CanRelocate;

    @Column(nullable = true)
    private int Zip;

    private String ProfileLinks;

    private String AdditionalDetails;

    public ContactDetails() {}

    public ContactDetails(List<String> phone, List<String> email, String country, String state, String city, boolean canRelocate, int zip, String profileLinks, String additionalDetails) {
        PhoneList = String.join("|", phone);
        EmailList = String.join("|", email);
        Country = country;
        State = state;
        City = city;
        CanRelocate = canRelocate;
        Zip = zip;
        ProfileLinks = profileLinks;
        AdditionalDetails = additionalDetails;
    }

    //region getters and setters

    public String getPhoneList() {
        return PhoneList;
    }

    public String getEmailList() {
        return EmailList;
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

    public void setPhoneList(String phone) {
        PhoneList = phone;
    }

    public void setEmailList(String email) {
        EmailList = email;
    }

    public void setPhone(List<String> phone) {
        PhoneList = String.join("|", phone);
    }

    public void setEmail(List<String> email) {
        EmailList = String.join("|", email);
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setState(String state) {
        State = state;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setZip(int zip) {
        Zip = zip;
    }

    public void setProfileLinks(String profileLinks) {
        ProfileLinks = profileLinks;
    }

    public void setAdditionalDetails(String additionalDetails) {
        AdditionalDetails = additionalDetails;
    }

    public void setAddress(String Address) {
        Country = Address;
    }

    public boolean getCanRelocate() {
        return CanRelocate;
    }

    public void setCanRelocate(boolean canRelocate) {
        CanRelocate = canRelocate;
    }

    @JsonIgnore
    public Cv getCv() {
        return Cv;
    }

    public void setCv(Cv cv) {
        Cv = cv;
    }

    //endregion getters and setters
}
