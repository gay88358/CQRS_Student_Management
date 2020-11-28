package student.read;

import common.Result;
import course.StudentEnrollmentConfig;
import course.write.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import student.read.studentEnrollment.EnrollmentDto;
import student.read.studentEnrollment.GetStudentEnrollmentQuery;
import student.read.studentEnrollment.GetStudentEnrollmentQueryHandler;
import student.write.domain.Grade;
import student.write.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentEnrollmentConfig.class})
@Transactional
public class GetStudentEnrollmentQueryHandlerTest {

    @PersistenceContext
    EntityManager entityManager;

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
        Course oop = new Course("OOP");
        entityManager.persist(oop);
        Course os = new Course("OS");
        entityManager.persist(os);
        Student student = new Student("Z-Xuan Hong");
        student.addEnrollment(oop, Grade.A);
        student.addEnrollment(os, Grade.A);
        entityManager.persist(student);
        return student.getId();
    }

}