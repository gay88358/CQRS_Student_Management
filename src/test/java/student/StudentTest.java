package student;

import course.write.Course;
import org.junit.Test;
import student.write.domain.Grade;
import student.write.domain.Student;

import static org.junit.Assert.*;

public class StudentTest {

    private final static Course OOP = new Course("OOP");
    private final static Course OS = new Course("OS");
    private final static Course FP = new Course("FP");

    @Test
    public void add_enrollment_to_student() {
        Student student = new Student("Z-Xuan Hong");
        student.addEnrollment(OOP, Grade.A);

        Grade grade = student.getGrade(OOP);
        assertEquals(Grade.A, grade);
    }

    @Test
    public void student_enroll_at_most_two_courses() {
        Student student = new Student("Z-Xuan Hong");
        student.addEnrollment(OOP, Grade.A);
        student.addEnrollment(OS, Grade.A);
        try {
            student.addEnrollment(FP, Grade.A);
            fail();
        } catch (RuntimeException e) {
            assertEquals("Student enroll at most two courses", e.getMessage());
        }
    }

    @Test
    public void enroll_duplicate_course_is_invalid() {
        Student student = new Student("Z-Xuan Hong");
        student.addEnrollment(OOP, Grade.A);
        try {
            student.addEnrollment(OOP, Grade.A);
            fail();
        } catch (RuntimeException e) {
            assertEquals("Student can not enroll duplicate courses", e.getMessage());
        }

    }
}