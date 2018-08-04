package cvc.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public void setName(String name) {
        Name = name;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public void setSuruDate(client.entities.Date startDate) {
        StartDate = new GregorianCalendar(startDate.year, startDate.month, startDate.day).getTime();
    }

    public void setAntimDate(client.entities.Date endDate) {
        EndDate = new GregorianCalendar(endDate.year, endDate.month, endDate.day).getTime();
    }

    public void setAdditionalInfo(String additionalInfo) {
        AdditionalInfo = additionalInfo;
    }

    //endregion getters and setters
}
