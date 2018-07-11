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

    public String getProficiency() {
        return Proficiency;
    }

    //endregion getters and setters
}
