package student.write.enrollCourse;

import common.Command;
import student.write.domain.Grade;

public class EnrollCourseCommand implements Command {
    private final Long studentId;
    private final Long courseId;
    private final Grade grade;

    public EnrollCourseCommand(Long studentId, Long courseId, Grade grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    Long getStudentId() {
        return studentId;
    }

    Grade getGrade() {
        return grade;
    }

    Long getCourseId() {
        return courseId;
    }
}
