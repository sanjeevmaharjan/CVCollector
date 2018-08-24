package cvc.domain;

import org.apache.tomcat.jni.Local;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

@MappedSuperclass
public abstract class OrganizationBase extends PersistentObject implements Serializable {
    String Name;

    LocalDate StartDate;

    LocalDate EndDate;

    String AdditionalInfo;

    public OrganizationBase() {}

    //region getters and setters

    public String getName() {
        return Name;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public String getAdditionalInfo() {
        return AdditionalInfo;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    public void setSuruDate(client.entities.Date startDate) {
        StartDate = LocalDate.parse(startDate.toString());
    }

    public void setAntimDate(client.entities.Date endDate) {
        EndDate = LocalDate.parse(endDate.toString());
    }

    public void setAdditionalInfo(String additionalInfo) {
        AdditionalInfo = additionalInfo;
    }

    public int getTimeEngaged() {
        return EndDate - StartDate;
    }
    //endregion getters and setters
}
