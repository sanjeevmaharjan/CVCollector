package cvc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import java.util.List;

@Entity
public class Users extends PersistentObject{
    private String Name;

    @Column(unique = true)
    private String Username;

    private String Password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> Roles;

    private boolean IsEnabled;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", unique = true, nullable = false)
    private Cv Cv;

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

    /**
     * @return the cv
     */
    @JsonIgnore
    public Cv getCv() {
        return Cv;
    }

    /**
     * @param cv the cv to set
     */
    public void setCv(Cv cv) {
        Cv = cv;
    }

    //endregion getters and setters
}
