package cvc.domain;

import javax.persistence.Entity;

@Entity
public class LanguageProficiency extends PersistentObject {
    private String Language;

    private String Proficiency;

    public LanguageProficiency() {}

    public LanguageProficiency(String language, String proficiency) {
        this.Language = language;
        this.Proficiency = proficiency;
    }

    //region getters and setters

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getProficiency() {
        return Proficiency;
    }

    public void setProficiency(String proficiency) {
        Proficiency = proficiency;
    }


    //endregion getters and setters
}
