package cvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Users extends PersistentObject{
    private String Name;

    @Column(unique = true)
    private String Username;

    private String Password;

    public Users() {}

    public Users(String name, String username, String password) {
        this.Name = name;
        this.Username = username;
        this.Password = password;
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

    //endregion getters and setters
}
