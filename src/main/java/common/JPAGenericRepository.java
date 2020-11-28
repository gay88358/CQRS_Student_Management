package common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class JPAGenericRepository<T> {

    @PersistenceContext
    EntityManager entityManager;

    private Class<T> entityClass;

    public JPAGenericRepository(Class<T> entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    public T findBy(Long id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        return entityManager
                .createQuery(
                "From" + entityClass.toString())
                .getResultList();
    }


    public void add(T t) {
        entityManager.persist(t);
    }
}
