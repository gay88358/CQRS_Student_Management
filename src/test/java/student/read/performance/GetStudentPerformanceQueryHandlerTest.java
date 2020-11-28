package student.read.performance;

import common.Result;
import common.StudentEnrollmentConfig;
import course.write.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import student.write.domain.Grade;
import student.write.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentEnrollmentConfig.class})
@Transactional
public class GetStudentPerformanceQueryHandlerTest {

    @PersistenceContext
    EntityManager entityManager;

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