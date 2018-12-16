package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NamedQuery(name = "Cv.findByUsername", query = "select count(c)from Users u where u.Username = ?1")
public class Users extends PersistentObject{
    private String Name;

    @Column(unique = true)
    private String Username;

    private String Password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> Roles;

    private boolean IsEnabled;

    /*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "User", targetEntity = Cv.class)
    private Set<Cv> Cvs;*/

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "User", targetEntity = CvSearchCriteria.class)
    private Set<CvSearchCriteria> CvSearchCriteria;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "User", targetEntity = Links.class)
    private Set<Links> Links;

    public Users() {}

    public Users(String name, String username, String password, List<Roles> roles) {
        this.Name = name;
        this.Username = username;
        this.Password = password;
        this.Roles = roles;
    }

    //region getters and setters

    public String getName() {
        return Name;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public List<Roles> getRoles() {
        return Roles;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setRoles(List<Roles> roles) {
        Roles = roles;
    }

    public boolean isEnabled() {
        return IsEnabled;
    }

    public void setEnabled(boolean enabled) {
        IsEnabled = enabled;
    }

/*    @JsonIgnore
    public Set<Cv> getCvs() {
        return Cvs;
    }

    public void setCvs(Set<Cv> cvs) {
        Cvs = cvs;
    }*/

    @JsonIgnore
    public Set<cvc.domain.CvSearchCriteria> getCvSearchCriteria() {
        return CvSearchCriteria;
    }

    public void setCvSearchCriteria(Set<cvc.domain.CvSearchCriteria> cvSearchCriteria) {
        CvSearchCriteria = cvSearchCriteria;
    }

    public Set<cvc.domain.Links> getLinks() {
        return Links;
    }

    public void setLinks(Set<cvc.domain.Links> links) {
        Links = links;
    }

    //endregion getters and setters
}
