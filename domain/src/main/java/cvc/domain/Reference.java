package cvc.domain;

import javax.persistence.Entity;

@Entity
public class Reference extends PersistentObject {
    private String Name;

    private String Contact;

    private String Organization;

    private String Designation;

    public Reference() {
    }

    public Reference(String name, String contact, String organization, String designation) {
        Name = name;
        Contact = contact;
        Organization = organization;
        Designation = designation;
    }

    //region getters and setters

    public String getName() {
        return Name;
    }

    public String getContact() {
        return Contact;
    }

    public String getOrganization() {
        return Organization;
    }

    public String getDesignation() {
        return Designation;
    }

    //endregion getters and setters
}
