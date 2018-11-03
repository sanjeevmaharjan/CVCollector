package cvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class PersistentObject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name="id")
    long Id;

    public PersistentObject() {}

    @JsonIgnore
    public long getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }
}
