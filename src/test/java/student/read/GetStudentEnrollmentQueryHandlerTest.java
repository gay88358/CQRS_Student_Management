package student.read;

import common.IntegrationTest;
import common.Result;
import course.write.Course;
import org.junit.Test;
import student.read.studentEnrollment.EnrollmentDto;
import student.read.studentEnrollment.GetStudentEnrollmentQuery;
import student.read.studentEnrollment.GetStudentEnrollmentQueryHandler;
import student.write.domain.Grade;
import student.write.domain.Student;

import java.util.List;

import static org.junit.Assert.*;

public class GetStudentEnrollmentQueryHandlerTest extends IntegrationTest {

    @Test
    public void get_student_enrollment_query() {
        // Arrange
        Long studentId = createStudentWithTwoEnrollment();
        GetStudentEnrollmentQuery query = new GetStudentEnrollmentQuery(studentId);
        GetStudentEnrollmentQueryHandler handler = new GetStudentEnrollmentQueryHandler(entityManager);
        // Act
        Result<List<EnrollmentDto>> result = handler.handle(query);
        // Assert
        List<EnrollmentDto> enrollmentDtos = result.getValue();
        assertEquals(enrollmentDtos.size(), 2);
        assertEquals(enrollmentDtos.get(0), new EnrollmentDto("Z-Xuan Hong", "OOP", Grade.A));
        assertEquals(enrollmentDtos.get(1), new EnrollmentDto("Z-Xuan Hong", "OS", Grade.A));
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