package common;

import course.write.Course;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentEnrollmentConfig.class})
@Transactional
public abstract class IntegrationTest {

    @PersistenceContext
    protected EntityManager entityManager;


    protected void create(Object o) {
        entityManager.persist(o);
    }

    protected void deleteAll(Class zlass) {
        entityManager
                .createQuery(
                "DELETE FROM " + zlass.getName()
                )
                .executeUpdate();
    }
}
