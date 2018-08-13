package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class AdditionalInfo extends PersistentObject {

    @OneToOne(optional = false, mappedBy = "AdditionalInfo", fetch = FetchType.LAZY, targetEntity = Cv.class)
    @JsonIgnore
    private Cv Cv;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LanguageProficiency> LanguageProficiencyList;

    private String Hobbies;

    private String Notes;

    public AdditionalInfo() {
    }

    public AdditionalInfo(List<LanguageProficiency> languageProficiencyList, String hobbies, String notes) {
        LanguageProficiencyList = languageProficiencyList;
        Hobbies = hobbies;
        Notes = notes;
    }

    //region getters and setters

    public List<LanguageProficiency> getLanguageProficiencyList() {
        return LanguageProficiencyList;
    }

    public String getHobbies() {
        return Hobbies;
    }

    public String getNotes() {
        return Notes;
    }

    public void setLanguageProficiencyList(List<LanguageProficiency> languageProficiencyList) {
        LanguageProficiencyList = languageProficiencyList;
    }

    public void setHobbies(String hobbies) {
        Hobbies = hobbies;
    }

    public void setNotes(String notes) {
        Notes = notes;
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
