package student.write;


import common.Result;
import course.StudentEnrollmentConfig;
import course.write.Course;
import course.write.CourseRepository;
import course.write.JPACourseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import student.write.domain.StudentRepository;
import student.write.domain.Grade;
import student.write.domain.Student;
import student.write.enrollCourse.EnrollCourseCommand;
import student.write.enrollCourse.EnrollCourseCommandHandler;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentEnrollmentConfig.class})
@Transactional
public class EnrollCourseCommandHandlerTest {

    @PersistenceContext
    EntityManager entityManager;

    private Course oop = new Course("OOP");
    private Student amber = new Student("Amber");
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;


    @Before
    public void setup() {
        entityManager.persist(amber);
        entityManager.persist(oop);
        studentRepository = new JPAStudentRepository(entityManager);
        courseRepository = new JPACourseRepository(entityManager);
    }

    @Test
    public void enroll_course_to_student() {
        // Arrange
        Long studentId = amber.getId();
        Long courseId = oop.getId();
        Grade grade = Grade.A;
        EnrollCourseCommand command = new EnrollCourseCommand(studentId, courseId, grade);
        EnrollCourseCommandHandler handler = new EnrollCourseCommandHandler(studentRepository, courseRepository);
        // Act
        Result<Boolean> result = handler.handle(command);
        // Assert
        assertTrue(result.getValue());
        assertEnrollCourseSuccessfully(studentId, courseId);
    }

    private void assertEnrollCourseSuccessfully(Long studentId, Long courseId) {
        Student student = studentRepository.findBy(studentId);
        Course course = courseRepository.findBy(courseId);
        assertEquals(Grade.A, student.getGrade(course));
    }
}