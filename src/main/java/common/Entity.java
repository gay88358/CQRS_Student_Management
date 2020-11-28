package common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    protected Entity() {
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entity))
            return false;

        Entity e = (Entity)o;
        if (referenceEquals(this, e)) {
            return true;
        }

        if (noIdentitySetup(this, e))
            return false;

        return identityEquals(this, e);
    }

    private boolean referenceEquals(Entity e1, Entity e2) {
        return e1 == e2;
    }

    private boolean noIdentitySetup(Entity e1, Entity e2) {
        return e1.id == null || e2.id == null;
    }

    private boolean identityEquals(Entity e1, Entity e2) {
        return e1.getId() == e2.getId();
    }

    public long getId() {
        return this.id;
    }

    protected void setId(Long id) {
        if (this.id != null)
            throw new RuntimeException("Identity can't be changed after initialized");
        this.id = id;
    }
}
