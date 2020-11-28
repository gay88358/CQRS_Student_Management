package student.write.domain;

import course.write.Course;
import student.write.domain.Enrollment;
import student.write.domain.Grade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
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
