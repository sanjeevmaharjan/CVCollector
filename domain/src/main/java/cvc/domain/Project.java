package cvc.domain;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Entity
public class Project extends PersistentObject {
    private String Title;

    private String Organizer;

    private LocalDate StartDate;

    private LocalDate EndDate;

    private String AdditionalDetails;

    public Project() {}

    public Project(String title, String organizer, LocalDate startDate, LocalDate endDate, String additionalDetails) {
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

    public LocalDate getStartDate() {
        return StartDate;
    }

    public LocalDate getEndDate() {
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

    public void setAdditionalDetails(String additionalDetails) {
        AdditionalDetails = additionalDetails;
    }

    //endregion getters and setters
}
