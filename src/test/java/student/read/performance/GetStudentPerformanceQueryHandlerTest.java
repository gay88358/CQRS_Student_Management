package student.read.performance;

import common.IntegrationTest;
import common.Result;
import course.write.domain.Course;
import org.junit.Test;
import student.write.domain.Grade;
import student.write.domain.Student;

import static org.junit.Assert.*;

public class GetStudentPerformanceQueryHandlerTest extends IntegrationTest {

    @Test
    public void get_student_performance_query() {
        // Arrange
        Long studentId = createStudentWithTwoEnrollment();
        GetStudentPerformanceQuery query = new GetStudentPerformanceQuery(studentId);
        GetStudentPerformanceQueryHandler handler = new GetStudentPerformanceQueryHandler(entityManager);
        // Act
        Result<StudentPerformanceDto> result = handler.handle(query);
        // Assert
        StudentPerformanceDto dto = result.getValue();
        assertEquals("Z-Xuan Hong", dto.getStudentName());
        assertEquals(100, dto.getStudentPerformance());
    }

    private Long createStudentWithTwoEnrollment() {
        Student student = new Student("Z-Xuan Hong");
        student.addEnrollment(createCourse("OOP"), Grade.A);
        student.addEnrollment(createCourse("OS"), Grade.A);
        create(student);
        return student.getId();
    }

    private Course createCourse(String name) {
        Course course = new Course(name);
        create(course);
        return course;
    }
}