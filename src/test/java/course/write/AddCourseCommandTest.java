package course.write;

import common.Result;
import course.StudentEnrollmentConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentEnrollmentConfig.class})
@Transactional
public class AddCourseCommandTest {

    @PersistenceContext
    EntityManager entityManager;

    private static final String COURSE_NAME = "OOP";

    @Test
    public void add_course() {
        // Arrangement
        CourseRepository repository = new JPACourseRepository();
        AddCourseCommand command = new AddCourseCommand(COURSE_NAME);
        AddCourseCommandHandler handler = new AddCourseCommandHandler(repository);
        // Act
        Result<Long> result = handler.handle(command);
        Long courseId = result.getValue();
        // Assert
        Course course = repository.findBy(courseId);
        assertEquals(COURSE_NAME, course.getName());
    }
}