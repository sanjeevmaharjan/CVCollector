package cvc.domain;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class PersistentObject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    long Id;

    public PersistentObject() {}

    public long getId() {
        return Id;
    }
}
