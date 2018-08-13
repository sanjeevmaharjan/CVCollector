package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class ProjectDetails extends PersistentObject {

    @OneToOne(optional = false, mappedBy = "Project", fetch = FetchType.LAZY, targetEntity = Cv.class)
    @JsonIgnore
    private Cv Cv;

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

    public void setProjects(List<Project> projects) {
        Projects = projects;
    }

    public void setAdditionalDetails(String additionalDetails) {
        AdditionalDetails = additionalDetails;
    }

    @JsonIgnore
    public Cv getCv() {
        return Cv;
    }

    public void setCv(Cv cv) {
        Cv = cv;
    }

    //endregion getters and setters
}
