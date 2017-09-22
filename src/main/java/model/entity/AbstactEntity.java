package model.entity;

import java.io.Serializable;

public abstract class AbstactEntity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }
}
