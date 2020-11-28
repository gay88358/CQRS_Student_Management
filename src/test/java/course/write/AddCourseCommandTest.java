package course.write;

import common.IntegrationTest;
import common.Result;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddCourseCommandTest extends IntegrationTest {

    private static final String COURSE_NAME = "OOP";

    @Test
    public void add_course() {
        // Arrangement
        CourseRepository repository = new CourseRepositoryImp(entityManager);
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