package student.write.domain;

import course.write.domain.Course;

import javax.persistence.*;

@Entity
@Table(name = "Enrollment")
public class Enrollment {
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    @Column(name = "grade")
    private Grade grade;

    @Id
    @GeneratedValue
    private Long id;

    protected Enrollment() {

    }

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
