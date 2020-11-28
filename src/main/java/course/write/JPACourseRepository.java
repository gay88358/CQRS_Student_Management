package course.write;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JPACourseRepository implements CourseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public JPACourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Course findBy(Long courseId) {
        return this.entityManager.find(Course.class, courseId);
    }

    @Override
    public void add(Course course) {
        System.out.println(this.entityManager);
        this.entityManager.persist(course);
    }
}
