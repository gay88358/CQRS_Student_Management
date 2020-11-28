package student.write.domain;

import course.write.Course;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student extends common.Entity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addEnrollment(Course course, Grade grade) {
        if (this.enrollments.size() >= 2) {
            throw new RuntimeException("Student enroll at most two courses");
        }
        if (this.enrollDuplicateCourse(course)) {
            throw new RuntimeException("Student can not enroll duplicate courses");
        }
        this.enrollments.add(new Enrollment(this, course, grade));
    }

    private boolean enrollDuplicateCourse(Course course) {
        return this.enrollments
                .stream()
                .anyMatch(e -> e.getCourse().equals(course));
    }

    public Grade getGrade(final Course course) {
        Enrollment enrollment = this.enrollments
                .stream()
                .filter(en -> en.getCourse().equals(course))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Given course id not in enrollment"));
        return enrollment.getGrade();
    }
}
