package common;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public abstract class JPAGenericRepository<T> {

    @PersistenceContext
    EntityManager entityManager;

    private Class<T> entityClass;

    public JPAGenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T findBy(Long id) {
        return entityManager.find(entityClass, id);
    }

    public List findAll() {
        return entityManager
                .createQuery(
                "From" + entityClass.toString())
                .getResultList();
    }


    public void add(T t) {
        entityManager.persist(t);
    }
}
