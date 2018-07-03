package cvc.domain;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Institution extends OrganizationBase {
    private String Degree;

    public Institution() {}

    public Institution(String name, String degree, Date startDate, Date endDate, String summary) {
        Name = name;
        Degree = degree;
        StartDate = startDate;
        EndDate = endDate;
        Summary = summary;
    }

    public String getDegree() {
        return Degree;
    }
}
