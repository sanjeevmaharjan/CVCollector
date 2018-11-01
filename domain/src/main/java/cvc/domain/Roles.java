package cvc.domain;

import javax.persistence.Entity;

@Entity
public class Roles extends PersistentObject{
    private String Name;

    public Roles() {}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Roles(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roles)) return false;

        Roles that = (Roles) o;

        if (getId() != that.getId()) return false;
        return getName().equals(that.getName());

    }
}
