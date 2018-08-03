package cvc.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class AdditionalInfo extends PersistentObject {
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

    //endregion getters and setters
}
