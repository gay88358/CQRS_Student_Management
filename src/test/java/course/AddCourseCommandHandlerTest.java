package course;

import course.write.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = {StudentEnrollmentConfig.class})
public class AddCourseCommandHandlerTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Transactional

    public void add_course() {

//        AddCourseCommand command = new AddCourseCommand();
//        AddCourseCommandHandler handler = new AddCourseCommandHandler();
//        Result<Long> result = handler.handle(command);

        System.out.println(this.entityManager);
        Course course = new Course("OOP");
        add(course);
//        Course result = findCourse(course.getId());
//        assertEquals("OOP", result.getName());
    }

    void add(Course course) {
        this.entityManager.persist(course);
    }

    Course findCourse(Long id) {
        return this.entityManager.find(Course.class, id);
    }
}