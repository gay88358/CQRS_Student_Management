package course.write;

import common.IntegrationTest;
import common.Result;
import course.write.addCourse.AddCourseCommand;
import course.write.addCourse.AddCourseCommandHandler;
import course.write.domain.Course;
import course.write.domain.CourseRepository;
import course.write.domain.CourseRepositoryImp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AddCourseCommandTest extends IntegrationTest {
    private static final String COURSE_NAME = "OOP";

    @Autowired
    CourseRepository repository;

    @Test
    public void add_course() {
        // Arrangement
        AddCourseCommand command = new AddCourseCommand(COURSE_NAME);
        AddCourseCommandHandler handler = new AddCourseCommandHandler(repository);
        // Act
        Result<Long> result = handler.handle(command);
        Long courseId = result.getValue();
        // Assert
        Course course = repository.findBy(courseId);
        assertEquals(COURSE_NAME, course.getName());
        System.out.println("123");
    }
}