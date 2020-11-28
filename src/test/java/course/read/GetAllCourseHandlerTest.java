package course.read;

import common.Result;
import course.StudentEnrollmentConfig;
import course.write.Course;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentEnrollmentConfig.class})
@Transactional
public class GetAllCourseHandlerTest {
    @PersistenceContext
    EntityManager entityManager;

    private final static String COURSE_ONE = "Course1";
    private final static String COURSE_TWO = "Course2";
    private final static String COURSE_THREE = "Course3";

    @Before
    public void setup() {
        addCourse(COURSE_ONE);
        addCourse(COURSE_TWO);
        addCourse(COURSE_THREE);
    }

    @Test
    public void get_all_course() {
        // Arrange
        GetAllCourseQuery query = new GetAllCourseQuery();
        GetAllCourseHandler handler = new GetAllCourseHandler(entityManager);
        // Act
        Result<List<CourseDto>> result = handler.handle(query);
        // Assert
        List<CourseDto> courseDtos = result.getValue();
        assertEquals(3, courseDtos.size());
        assertEquals(createExpectedCourseDto(), courseDtos);

    }

    private List<CourseDto> createExpectedCourseDto() {
        return Arrays.asList(
                new CourseDto(COURSE_ONE),
                new CourseDto(COURSE_TWO),
                new CourseDto(COURSE_THREE)
        );
    }

    private void addCourse(String name) {
        this.entityManager.persist(new Course(name));
    }


}