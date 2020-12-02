package student.write;


import common.IntegrationTest;
import common.Result;
import course.write.domain.Course;
import course.write.domain.CourseRepository;
import course.write.domain.CourseRepositoryImp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import student.write.domain.StudentRepository;
import student.write.domain.Grade;
import student.write.domain.Student;
import student.write.domain.StudentRepositoryImp;
import student.write.enrollCourse.EnrollCourseCommand;
import student.write.enrollCourse.EnrollCourseCommandHandler;

import static org.junit.Assert.*;

public class EnrollCourseCommandHandlerTest extends IntegrationTest {

    private Course oop = new Course("OOP");
    private Student amber = new Student("Amber");

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Before
    public void setup() {
        create(amber);
        create(oop);
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