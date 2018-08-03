package cvc.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class OrganizationBase extends PersistentObject implements Serializable {
    String Name;

    Date StartDate;

    Date EndDate;

    String AdditionalInfo;

    public OrganizationBase() {}

    //region getters and setters

    public String getName() {
        return Name;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public String getAdditionalInfo() {
        return AdditionalInfo;
    }

    //endregion getters and setters
}
