package student.write.domain;

import course.write.domain.Course;

import javax.persistence.*;

@Entity
@Table(name = "Enrollment")
public class Enrollment {
    @ManyToOne
    @JoinColumn(name = "studentId")
    private final Student student;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private final Course course;

    @Column(name = "grade")
    private final Grade grade;

    @Id
    @GeneratedValue
    private Long id;

    public Enrollment(Student student, Course course, Grade grade) {
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    public Course getCourse() {
        return this.course;
    }

    public Grade getGrade() {
        return this.grade;
    }


}
