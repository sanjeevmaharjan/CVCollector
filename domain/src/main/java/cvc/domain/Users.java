package cvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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

    //endregion getters and setters
}
