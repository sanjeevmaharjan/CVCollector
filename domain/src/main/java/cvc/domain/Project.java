package cvc.domain;

import javax.persistence.Entity;
import java.util.Date;

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

    //endregion getters and setters
}
