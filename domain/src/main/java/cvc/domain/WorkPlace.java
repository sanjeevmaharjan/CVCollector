package cvc.domain;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class WorkPlace extends OrganizationBase {
    private String Designation;

    public WorkPlace() {}

    public WorkPlace(String name, String designation, Date startDate, Date endDate, String summary) {
        Name = name;
        Designation = designation;
        StartDate = startDate;
        EndDate = endDate;
        AdditionalInfo = summary;
    }

    public String getDesignation() {
        return Designation;
    }
}
