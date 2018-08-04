package cvc.domain;

import javax.persistence.Entity;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
public class Project extends PersistentObject {
    private String Title;

    private String Organizer;

    private Date StartDate;

    private Date EndDate;

    private String AdditionalDetails;

    public Project() {}

    public Project(String title, String organizer, Date startDate, Date endDate, String additionalDetails) {
        Title = title;
        Organizer = organizer;
        StartDate = startDate;
        EndDate = endDate;
        AdditionalDetails = additionalDetails;
    }

    //region getters and setters

    public String getTitle() {
        return Title;
    }

    public String getOrganizer() {
        return Organizer;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public String getAdditionalDetails() {
        return AdditionalDetails;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setOrganizer(String organizer) {
        Organizer = organizer;
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

    public void setAdditionalDetails(String additionalDetails) {
        AdditionalDetails = additionalDetails;
    }

    //endregion getters and setters
}
