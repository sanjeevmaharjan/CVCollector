package cvc.domain;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class WorkPlace extends OrganizationBase {
    private String Designation;

    public WorkPlace() {}

    public WorkPlace(String name, String designation, LocalDate startDate, LocalDate endDate, String summary) {
        Name = name;
        Designation = designation;
        StartDate = startDate;
        EndDate = endDate;
        AdditionalInfo = summary;
        setTimeEngaged();
    }
    
    public WorkPlace(String name, String designation, String startDate, String endDate, String summary) {
        Name = name;
        Designation = designation;
        StartDate = LocalDate.parse(startDate);
        EndDate = LocalDate.parse(endDate);
        AdditionalInfo = summary;
        setTimeEngaged();
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}
