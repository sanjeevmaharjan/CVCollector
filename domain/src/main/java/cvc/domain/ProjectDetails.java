package cvc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ProjectDetails extends PersistentObject {
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Project> Projects;

    private String Summary;

    public ProjectDetails() {}

    public ProjectDetails(List<Project> projects, String summary) {
        Projects = projects;
        Summary = summary;
    }

    //region getters and setters

    public List<Project> getProjects() {
        return Projects;
    }

    public String getSummary() {
        return Summary;
    }

    //endregion getters and setters
}
