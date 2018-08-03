package cvc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ProjectDetails extends PersistentObject {
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Project> Projects;

    private String AdditionalDetails;

    public ProjectDetails() {}

    public ProjectDetails(List<Project> projects, String additionalDetails) {
        Projects = projects;
        AdditionalDetails = additionalDetails;
    }

    //region getters and setters

    public List<Project> getProjects() {
        return Projects;
    }

    public String getAdditionalDetails() {
        return AdditionalDetails;
    }

    //endregion getters and setters
}
