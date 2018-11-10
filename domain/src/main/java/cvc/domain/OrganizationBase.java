package cvc.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@MappedSuperclass
public abstract class OrganizationBase extends PersistentObject implements Serializable {
    String Name;

    LocalDate StartDate;

    LocalDate EndDate;

    String AdditionalInfo;

    int TimeEngaged = -1;

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
        if (EndDate != null) {
            setTimeEngaged();
        }
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
        if (StartDate != null) {
            setTimeEngaged();
        }
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
        if (TimeEngaged < 0) {
            setTimeEngaged();
        }

        return TimeEngaged;
    }

    public void setTimeEngaged(int i) {
        TimeEngaged = i;
    }

    public void setTimeEngaged() {
        if (StartDate == null || EndDate == null || EndDate.compareTo(StartDate) < 0)
            return;
        TimeEngaged = TimeEngaged = Period.between(StartDate, EndDate).getYears();
    }
    //endregion getters and setters
}
