package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NamedQuery(name = "Links.findByUser", query = "select l from Links l join l.User u where u.Username = ?1")
public class Links extends PersistentObject {

    @ManyToOne(fetch = FetchType.LAZY)
    private Users User;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "Links", targetEntity = Cv.class)
    private List<Cv> Cvs;

    private String Purpose;

    public Links() {}

    @JsonIgnore
    public Users getUser() {
        return User;
    }

    public void setUser(Users user) {
        User = user;
    }

    @JsonIgnore
    public List<Cv> getCvs() {
        return Cvs;
    }

    public void setCvs(List<Cv> cvs) {
        Cvs = cvs;
    }

    public String getPurpose() {
        return Purpose;
    }

    public void setPurpose(String purpose) {
        Purpose = purpose;
    }

    public int getCvCount() {
        return this.Cvs.size();
    }

    public String getCompany() {
        return User.getName();
    }

}
