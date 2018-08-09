package cvc.domain;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Institution extends OrganizationBase {
    private String Degree;

    private String Concentration;

    public Institution() {}

    public Institution(String name, String degree, LocalDate startDate, LocalDate endDate, String additionalInfo) {
        Name = name;
        Degree = degree;
        StartDate = startDate;
        EndDate = endDate;
        AdditionalInfo = additionalInfo;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public String getConcentration() {
        return Concentration;
    }

    public void setConcentration(String concentration) {
        Concentration = concentration;
    }
}
