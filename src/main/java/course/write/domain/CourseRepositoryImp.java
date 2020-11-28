package course.write.domain;

import common.JPAGenericRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepositoryImp extends JPAGenericRepository<Course> implements CourseRepository {

    public CourseRepositoryImp(EntityManager entityManager) {
        super(Course.class, entityManager);
    }

    @Override
    public Course findBy(Long courseId) {
        return super.findBy(courseId);
    }

    @Override
    public void add(Course course) {
        super.add(course);
    }
}
