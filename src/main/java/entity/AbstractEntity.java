package entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Влад on 08.11.2016.
 */
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue
    private Long id = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
